# Hello World program in Python
def elementCheck(name,symbol):
    for x in range(len(name)):
        if symbol[0].lower() == name[x].lower():
            #print "match:",x,name[x]
            for n in range((x + 1),len(name)):
                if symbol[1].lower() == name[n].lower():
                    #print "match#2: ",n,name[n]
                    print "true"
                    return
    print "false"

name1 = "Stantzon"
symbol1 = "Zt"
name2 = "Spenglerium"
symbol2 = "Ee"

elementCheck(name1,symbol1)
elementCheck(name2,symbol2)




                
            
        

