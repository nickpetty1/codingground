#template builder
def ospf(interface,ip,area):
    file.write("router ospf 1 \n")
    file.write((" network %s 0.0.0.0 area %s\n") % (ip, area))
    file.write(" passive-interface default\n")
    file.write((" no passive-interface %s\n") % interface)
    print "OSPF added to template"
    
def ospfAddInterface(interface,ip,area):
    file.write((" network %s 0.0.0.0 area %s\n") % (ip, area))
    file.write((" no passive-interface %s\n") % interface)
    print "OSPF interface added to template"

def startOSPF():
    choice = raw_input("OSPF? (Y/N)").lower()

    if choice == "y":
        ospfInterface = raw_input("What interface?")
        ospfNetwork = raw_input("What IP?")
        ospfArea = raw_input("What area?")
        ospf(ospfInterface,ospfNetwork,ospfArea)

        while(choice == "y"):
            choice = raw_input("Another OSPF Interface?").lower()

            if choice == "y":
                ospfInterface = raw_input("What interface?")
                ospfNetwork = raw_input("What IP?")
                ospfArea = raw_input("What area?")
                ospfAddInterface(ospfInterface,ospfNetwork,ospfArea)

file = open("text.py", 'w')
startOSPF()



