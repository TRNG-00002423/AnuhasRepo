print(" ")
print(" ")

def my_decorator(func):
    def wrapper():
        print("Before Function Call ...")
        func()
        print("After Function Call")
    return wrapper

@my_decorator
def greet():
    print("Greet !")

@my_decorator
def hello():
    print("Hello !")


# print("Before The Function")
# print(" ")
greet()
print(" ")
# print("After The Function")
# print("Before The Function")
# print(" ")
hello()
print(" ")
# print("After The Function")


print(" ")
print(" ")