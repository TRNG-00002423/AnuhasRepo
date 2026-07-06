print("")
print("")


def greet(name):
    return f"Hello {name}"



# Assign it to a variable

say_hello=greet
print(say_hello("Jasdhir"))


# Pass Function As An Argument

def apply(func, value):
    return func(value)


print(apply(greet, "Andrew"))


print("")
print("")