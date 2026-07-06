import logging
import logging.handlers
import os

print(" ")
print(" ")


logger=logging.getLogger("my_logger")
logger.setLevel(logging.DEBUG)

# Creating Handlers - Console
console=logging.StreamHandler()
console.setLevel(logging.INFO)
console.setFormatter(logging.Formatter("%(asctime)s | %(levelname) -8s  | %(message)s"))


# File Handler
log_file="my_logs.log"
file_handler=logging.FileHandler(log_file, mode="w")
file_handler.setFormatter(logging.Formatter(
    fmt="%(asctime)s | %(levelname) -8s  | %(message)s",
    datefmt="%H:%M:%S"
))

print(" ")
print(" ")


logger.addHandler(console)
logger.addHandler(file_handler)

logger.debug("This is a DEBUG message")
logger.info("This is an INFO message")
logger.warning("This is Warning message")
logger.error("This is an Error Message")

print(" ")
logging.critical(" THIS IS A CRITICAL MESSAGE")

print(" ")
print(" ")
