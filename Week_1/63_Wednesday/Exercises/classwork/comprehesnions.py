# Comprehensions are a pythonic way to Transform & Filter Data
# Comprehensions is compact, declarative syntax


# calculate squaers of number from 1 to 9

print("")
print("")



for num in range(10):
    sq=num**2
    print(sq)


print("")

squares=[x**2 for x in range(10)]
print(f"{squares}")

print("")
print("")
squares_even=[x**2 for x in range(10) if x%2==0]
print(f"{squares_even}")


print("")
print("")

names = ["Alice", "Bob", "Charlie"]
name_len = {name:len(name) for name in names}

for key, value in name_len.items():
    print(f"Key : {key}         | Value : {value}")


print("")
print("")