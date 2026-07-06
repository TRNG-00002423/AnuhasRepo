print("")
print("")

# Regular Function
def add(a,b):
    return a+b

# Lambda
add_lambda = lambda a,b: a+b
print(add(2,3))
print(" ")
print(add_lambda(3,3))


print("")
print("")



# Map, Reduce, Filter, Zip



# Map : map() applies a function to every element of an iterable

numbers=[1,2,3,4,5]
double=list(map(lambda x: x*2, numbers))
print(double)


print("")
print("")


Names=["oscar","audy","curtis"]

capitalize_names=list(map(lambda name: name.capitalize(), Names)) # Capitalizes Each Name in the Names List

for name in capitalize_names:
    print(name)


print("")
print("")

# filter() - filters based on a predicate function or condition - Filter Evens
numbers = [1,2,3,4,5,6,7,8,9,10]

numbers_filtered=list(filter(lambda x: x%2==0, numbers))

for number in numbers_filtered:
    print(number)


print("")
print("")


# reduce () - often used as aggregator - Find Sum
numbers=[1,2,3,4,5]

from functools import reduce                # Can Use An Import Statement Anywhere In Python

total=reduce(lambda a,x:a+x, numbers)

print(f"{total}")

print("")
print("")


# zip() : takes 2 or more iterables and combines them element by element in touples 
names = ["Ken", "Natalie", "Thomas"]
grade = [85, 92, 84]
zip_name_grade = zip(names, grade)

list_name_grade=list(zip_name_grade)
print(list_name_grade)



print("")
print("")

print("")
print("")
