import csv
import random
with open('studentWithIds.csv', newline='') as f:
    reader = csv.reader(f)
    student = list(reader)

with open('courses.csv', newline='') as f:
    reader = csv.reader(f)
    course = list(reader)

attends=[]
for i in student:
    attends.append([i[0]])

for i in attends:
    r=random.randint(0, 9)
    i.append(course[r][0])

for i in attends:
    r=random.randint(0, 9)
    i.append(r)

with open("attendswithgrade.csv", "w", newline="") as f:
    writer = csv.writer(f)
    writer.writerows(attends)
