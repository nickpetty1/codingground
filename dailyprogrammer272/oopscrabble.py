#Recreating reddit daily programmer scrabble with OOP concepts

class scrabble:
    
    def __int__(self):
        letters = {}
    
    def letterList(self):
        letterCount = { "a": (9,1), "b":(2,3), "c":(2,3), "d":(4,2), "d":(4,2), "e":(12,1), 
"f":(2,4), "g":(3,2), "h":(2,4), "i":(9,2), "j":(1,8), "k":(1,5), "l":(4,1),
"m":(2,3), "n":(6,1), "o":(8,1), "p":(2,3), "q":(1,10), "r":(6,1), "s":(4,1),
"t":(6,1), "u":(4,1), "v":(2,4), "w":(2,4), "x":(1,8), "y":(2,4), "z":(1,10), "_":(2,0)}
        return letterCount

    def count(self,input):
        for letter in input:
            self.letters[letter] = ((self.letters[letter][0] - 1), self.letters[letter][1])

    def output(self):
        for letter in self.letters:
            if self.letters[letter][0] < 0:
                print "Invalid Input. More %s have been taken from the bag than possible." % letter.upper()
                return
        for x in range(12,-1,-1):
            outputList = []
            for index in self.letters:
                if self.letters[index][0] == x:
                    outputList.append(index)
            outputList = sorted(outputList)
            if len(outputList) > 0:
                print x,":",((",".join(outputList).upper()))

def execute(x,userInput):
    x = scrabble()
    x.letters = x.letterList()
    x.count(userInput)
    x.output()

input1 = "PQAREIOURSTHGWIOAE_".lower()
execute("s",input1)

input2 = "LQTOONOEFFJZT".lower()
execute("s1",input2)

input3 = "AXHDRUIOR_XHJZUQEE".lower()
execute("s2",input3)
