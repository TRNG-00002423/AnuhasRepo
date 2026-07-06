# Dictionary : Key - Value Pair


print(" ")
print(" ")

student={
    "name":"Utsav",
    "age":25,
    "grade":"A"
}




print(student["name"])
print(" ")
print(student.get("age"))
print(" ")



student["grade"]="A+"
student["city"]="Lousiville"


for key,value in student.items():
    print(key, value)

student.keys()
student.values()
student.items()
student.get("key")

print(" ")
print(" ")