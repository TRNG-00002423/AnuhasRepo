# Sets : Mutable, Unordered, Unique


print(" ")
print(" ")

ids = {1,2,3,4,5}


empty_set = set()


numbers = {1,2,2,3,4,5,3}
from_list = set([10,20,20,30])  # Creating A Set From A List


ids = {1,2,3}
ids.add(4)
ids.add(2)


ids.remove(1)
# ids.remove(100)             # KeyError


ids.discard(2)
ids.discard(100)              # No Error


val = ids.pop()

ids.clear()

print(" ")
print(" ")


fruits={"apple", "banana", "mango", "carrot"}
veggies={"cabbage","carrot","lettuce"}

fruits_and_veggies=fruits.union(veggies)            # Union
print(fruits_and_veggies)


fruits_or_veggies = fruits.intersection(veggies)    # Intersection

print(" ")
print(" ")


print(fruits_or_veggies)

print(" ")
print(" ")