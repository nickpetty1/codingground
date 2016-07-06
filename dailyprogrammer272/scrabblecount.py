def letterList():
    letterCount = { "a": (9,1), "b":(2,3), "c":(2,3), "d":(4,2), "d":(4,2), "e":(12,1), 
"f":(2,4), "g":(3,2), "h":(2,4), "i":(9,2), "j":(1,8), "k":(1,5), "l":(4,1),
"m":(2,3), "n":(6,1), "o":(8,1), "p":(2,3), "q":(1,10), "r":(6,1), "s":(4,1),
"t":(6,1), "u":(4,1), "v":(2,4), "w":(2,4), "x":(1,8), "y":(2,4), "z":(1,10), "_":(2,0)}
    return letterCount

def count(input):
    letterOutput = {}
    for letter in input:
        letters[letter] = ((letters[letter][0] - 1), letters[letter][1])

def output(input):
    for letter in letters:
        if letters[letter][0] < 0:
            print "Invalid Input. More %s have been taken from the bag than possible." % letter.upper()
            return
    for x in range(12,-1,-1):
        outputList = []
        for index in letters:
            if letters[index][0] == x:
                outputList.append(index)
        outputList = sorted(outputList)
        if len(outputList) > 0:
            print x,":",((",".join(outputList).upper()))


input = "PQAREIOURSTHGWIOAE_".lower()
letters = letterList()
count(input)
output(letters)

input = "LQTOONOEFFJZT".lower()
letters = letterList()
count(input)
output(letters)

input = "AXHDRUIOR_XHJZUQEE".lower()
letters = letterList()
count(input)
output(letters)
