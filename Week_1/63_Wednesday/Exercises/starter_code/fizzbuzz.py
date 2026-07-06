"""
fizzbuzz.py : 
Involves :
- 
"""

# TODO 1 : Implement `fizzbuzz(n)` that prints numbers 1 through `n` with these rules:
# - Divisible by 3: print "Fizz"
# - Divisible by 5: print "Buzz"
# - Divisible by 7: print "Boom"
# - Divisible by 3 AND 5: print "FizzBuzz"
# - Divisible by 3 AND 7: print "FizzBoom"
# - Divisible by 5 AND 7: print "BuzzBoom"
# - Divisible by 3 AND 5 AND 7: print "FizzBuzzBoom"
# - Otherwise: print the number


print("")
print("")


def fizzbuzz(n):
    if ((((n%3)==0) & ((n%7)==0)) & ((n%5)==0)):
        print("FizzBuzzBoom")
    elif (((n%3)==0) & ((n%5)==0)):
        print("FizzBuzz")
    elif (((n%3)==0) & ((n%7)==0)):
        print("FizzBoom")
    elif (((n%5)==0) & ((n%7)==0)):
        print("BuzzBoom")
    elif ((n%3)==0):
        print("Fizz")
    elif ((n%5)==0):
        print("Buzz")
    elif ((n%7)==0):
        print("Boom")
    else:
        print(f"{n}")


fizzbuzz(105)
print("")
print("")
