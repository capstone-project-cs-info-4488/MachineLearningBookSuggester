import requests # Need to install this package to use script. (pip install requests)
import xml.etree.ElementTree as ET
import time

# User variables
key = '' # Need to add your own key, and remove before pushing to github.
outputfilename = 'books.txt'
minrating = 4
maxresults = 200 # Cant be greater than 200 currently, TODO: Add support for multiple page results


# Shouldn't need to change any variables beyond here. Edit at own risk.
pageresults = maxresults if maxresults <= 200 else 200

urlreviews = 'https://www.goodreads.com/review/recent_reviews.xml?key=%s'
urlread = 'https://www.goodreads.com/review/list/%s.xml?key=%s&v=2&shelf=read&per_page=%s'

req = requests.get(urlreviews % (key))
root = ET.fromstring(req.content)

reviews = root[1]


if os.path.exists(outputfilename):
    append_write = 'a'
else:
    append_write = 'w'

f = open(outputfilename, append_write)

for review in reviews:
    user = None
    books = []
    
    for child in review:
        if child.tag == 'user':
            user = child
        elif child.tag == 'book':
            book = child

    if user != None:
        time.sleep(1) # TODO: Account for processing time of XML to reduce wait

        userid = user[0].text
        readreq = requests.get(urlread % (userid, key, pageresults))
        readroot = ET.fromstring(readreq.content)

        if len(readroot) > 0:
            read = readroot[2]
            print('%s has read %s books.' % (user[2].text, read.attrib.get('total')))
            
            for child in read:
                bookid = child[1][0].text
                rating = float(child[2].text)

                if rating >= minrating:
                    books.append(bookid)

            if len(books) > 0:
                f.write(userid + ': ') # TODO: Use some sort of indexing to avoid storing userid
                f.write(' '.join([str(b) for b in books]))
                f.write('\n')
            
            print('%s books were given a rating of %s or more and were written to %s' % (len(books), minrating, outputfilename))
                    
        else:
            print('%s does not allow access to read books' % (user[2].text))
