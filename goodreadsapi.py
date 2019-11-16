import requests
import random
import os

cur_path = os.path.dirname(__file__)
unique = 1
while unique == 1:
    url = 'https://goodreads.com/review/list/'
    rand = random.randint(1, 105012260)
    url += rand.__str__()
    url += '.xml?key=pR3s7yXmk01HKb1ArFCf2w&v=2'
    r = requests.get(url, allow_redirects=True)
    file = '/home/bosejaso/PycharmProjects/untitled/data/goodreadsdata'
    file += rand.__str__()
    file += '.txt'
    new_path = os.path.relpath(file, cur_path)
    if not os.path.isfile(file):
        open(file, 'wb').write(r.content)
        unique = 0
