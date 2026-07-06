# List : ordered and mutable collection of items


# Empty List


print(" ")
print(" ")

test = []

# List with some values

tests = ["login", "search", "checkout"]
mixed_list = [1,"login",True,"search","checkout"]

print(tests[0])
print(tests[1])
print(tests[-1])


print(" ")
print(" ")


# Modify A List

tests[1] = "advance search"
tests.append("logout")
tests.insert(0, "open page")
print(tests)

print(" ")
print(" ")

tests.remove("login")
removed=tests.pop()

del tests[0]

len(tests)                      # returns the length


print(" ")
print(" ")

"login" in tests                # T or F


tests.index("checkout")

tests.count("login")

tests.sort()


tests.sort(reverse=True)


tests.reverse()


numbers=[1,2,3,4,5,6]
print(numbers[1:4])             # Slicing



numbers[:4]
numbers[3:]

