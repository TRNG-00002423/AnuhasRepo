print(" ")
print(" ")

sq_list=[x*x for x in range(5)]     # List Comprehension
print(sq_list)

print(" ")
print(" ")


def get_numbers():
    
    numbers = []

    for i in range(1,6):
        numbers.append(i)

    return numbers


result=get_numbers()
print(result)
print(" ")
print(" ")

def get_numbers():
    for i in range(1,6):
        yield i


gen=get_numbers()
print(gen)
print(" ")
print(" ")

for num in gen:
    print(num)

print(" ")
print(" ")
print("*"*20)
print(" ")
print(" ")
gen=(i for i in range(1,6))

for n in gen:
    print(n)



print(" ")
print(" ")