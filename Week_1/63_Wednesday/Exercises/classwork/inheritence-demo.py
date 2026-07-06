print("")
print("")

class Animal:

    def __init__(self,name):
        self.name=name

    def speak(self):
        return "...."
    


class Dog(Animal):

    def speak(self):
        return "Woof !"
    

class Cat(Animal):
    
    def speak(self):
        return "Meow !"
    

Rex = Dog("Rex")
print(f"{Rex.name} says {Rex.speak()}")


Panda = Cat("Pandas")
print(f"{Panda.name} says {Panda.speak()}")



print("")
print("")