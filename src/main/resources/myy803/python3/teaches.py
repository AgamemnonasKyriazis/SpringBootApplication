import csv
import random
with open('instructors.csv', newline='') as f:
    reader = csv.reader(f)
    instructor = list(reader)

with open('courses.csv', newline='') as f:
    reader = csv.reader(f)
    course = list(reader)


instid=[]
for i in instructor:
    instid.append([i[2]])


for i in instid:
    r=random.randint(0, 9)
    i.append(course[r][0])


with open("Teaches.csv", "w", newline="") as f:
    writer = csv.writer(f)
    writer.writerows(instid)
