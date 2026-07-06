print("")
print("")

# result = 10/0
# print(Result)



try:
    # Code that might raise an Exception
    result = int(input("Enter A Number :  "))
except ValueError:
    # If A Value Error Occurs
    print(" ")
    print(f"That Is Not A Number -- {e}")
    print(" ")
    raise ZeroDivisionError("Some Text")
except(TypeErrpr, KeyError) as e:
    print(f"{e}")
else:
    print(" ")
    print("No Exception")
finally:
    print(" ")
    print("Clean Up Code")


print("")
print("")