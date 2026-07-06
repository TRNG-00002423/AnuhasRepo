"""
Hello QA — Your first Python script.
Fill in the code below where you see # TODO comments.
"""

import sys

# TODO 1: Ask the user for their name using input()
print("")
name = input("Please Enter Your Name : ")

# TODO 2: Ask the user for their role
print("")
role = input("Please Input Your Role : ")

# TODO 3: Print a greeting using an f-string
# Expected: "Welcome, {name}! Your role is {role}."
print("")
print("═" * 40)
print(f"Welcome, {name}! Youre role is : {role}!")
print("═" * 40)
print("")

# TODO 4: Print the Python version
# Hint: sys.version_info gives you (major, minor, micro)
print(f"Python version : {sys.version_info.major}.{sys.version_info.minor}.{sys.version_info.micro}")
print("")
# print(sys.version_info.major)
# print(sys.version_info.minor)
# print(sys.version_info.micro)

