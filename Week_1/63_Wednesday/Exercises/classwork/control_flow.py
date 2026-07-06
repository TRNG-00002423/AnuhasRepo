"""
control-flow.md : 
Involves :
- Classwork, Wednesday June 3rd, Week 1 - Day 3
"""


print("")
print("")
print("")

Score = 85

if (Score>=90):
    grade = 'A'
elif (Score>=80):
    grade = 'B'
elif (Score>=70):
    grade = 'C'
# elif (Score>=60):
#     grade = 'D'
else:
    grade = 'F'


print(f"Score : {Score} ---> Grade : {grade}")
print("")
print("")

# Ternary Operator
grade='PASS' if (Score>=60) else 'FAIL'


SCORE = [95,85,75,65,55]

for score in [95,85,75,65,55]:
    if (score>=90):
        grade = 'A'
    elif (score>=80):
        grade = 'B'
    else:
        grade = 'F'
    print(f"Score : {score} ---> Grade : {grade}")



print("")
print("")
print("")



tests = ["login", "search", "checkout", "ignore"]

for test in tests:
    print(test.upper())

index = 0 

while (index<len(tests)):
    print(tests[index].upper())
    index = index + 1


numbers = [4, 5, 7, 2, -5, 9, -2, 5, -3, 1, 0, 8]

# for number in numbers:
#     match number:
#         case number if (number<0):
#             print("A")
#             print(f"{number}")
#             # continue
#         case number if (number>0):
#             print(f"{number}")
#         case number if (number==0):
#             break
#         # case _:
#         #     continue



for number in numbers:
    if (number>0):
        print(f"{number}")
    elif (number<0):
        print(f"Skipping : {number}")
    if (number==0):
        break

print(" ")
print(" ")