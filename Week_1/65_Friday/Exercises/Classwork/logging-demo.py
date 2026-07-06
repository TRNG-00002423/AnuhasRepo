import logging

print(" ")
print(" ")

print("print vs logging")
print("Application Started .....")
print("Something Went Wrong ....")
print("Lets Log This ...........")


logging.basicConfig(

    level=logging.DEBUG,
    # level=logging.WARNING,
    # level=logging.ERROR,
    format='%(asctime)s  | %(levelname) -8s  |  %(message)s',
    datefmt='%H:%M:%S'

)


print(" ")
print(" ")


#Broadcast Logs
logging.debug("This is a DEBUG message")
logging.info("This is INFO")
logging.warning("This is Warning Message")
logging.error("This Is Error Message")
logging.critical("This Is A Critical Message")


print(" ")
print(" ")