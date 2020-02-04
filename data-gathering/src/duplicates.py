filename = 'books.txt'
createnew = True

f = open(filename, 'r')

if createnew:
    o = open('+' + filename, 'w')
         
ids = []
hash = dict()
duplicatecount = 0


for line in f:
    id = line.split(' ')[0][:-1]

    if id in hash:
        #print(id + ' duplicate')
        duplicatecount += 1
    else:
        hash[id] = 1
        if createnew:
            o.write(line)
        
print(str(duplicatecount) + ' duplicates were found.')
f.close()

if createnew:
    o.close()
