#CSV at https://www.reddit.com/r/dailyprogrammer/comments/49aatn/20160307_challenge_257_easy_in_what_year_were/
import csv
import re

presidentFile = open('presidents.csv')
presidentReader = csv.reader(presidentFile)
presidentData = list(presidentReader)

years = {}
#build year table
for x in range(1732,2017):
    years[x] = 0
#Regex to pull year from csv
presRegex = re.compile(r'\d\d\d\d')

#Goes through the list and pulls birth and deaths, adds range to the years table
for x in range(1,len(presidentData)):
    try:
        birthRegex = presRegex.search(presidentData[x][1])
        birth = int(birthRegex.group())
    except AttributeError:
        pass
    try:
        deathRegex = presRegex.search(presidentData[x][3])
        death = int(deathRegex.group())
    except AttributeError:
        death = 2016
    
    for n in range(birth,death+1):
        years[n] += 1

maxnum = 0
maxYears = []
#Finds what the max amount of presidents alive are
for y in years:
    if years[y] > maxnum:
        maxnum = years[y]
#Finds all years that match the max number of presidents that are alive
for y in years:
    if years[y] == maxnum:
        maxYears.append(y)

print maxYears
