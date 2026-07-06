"""
TYPE EXPLORER
"""


# TODO 1: Declare and print each variable, its value, and its type using f-strings.
Name = "Lucy"
Age = 3
Price = 399.99
Is_Vaccinated = True
Test_Result = None

print("")
print("═" * 40)
print("  Variable Exploration : ")
print("═" * 40)
print("")
print(f"Name          = {Name}          {type(Name)}")
print(f"Age           = {Age}             {type(Age)}")
print(f"Price         = {Price}        {type(Price)}")
print(f"Is_Vaccinated = {Is_Vaccinated}          {type(Is_Vaccinated)}")
print(f"Test_Result   = {Test_Result}          {type(Test_Result)}")

print("")






# TODO 2: Demonstrate Integer division (`//`) vs. regular division (`/`)
integer_div = 18//5
regular_div = 18/5

print("")
print("═" * 40)
print("  Operators Demo : ")
print("═" * 40)
print("")
print(f"18//5    = {integer_div}      (FLOOR DIVISION)")
print(f"18/5     = {regular_div}    (TRUE DIVISION)")
print("")







# TODO 3: Demonstrate String multiplication (`"abc" * 3`)
print("")
print("═" * 40)
print("  String Multiplication Demo : ")
print("═" * 40)
print("")
print("Testing * 10    : "+"Testing "*10)
print("")
print("QA * 5          : "+"QA "*5)
print("")






# TODO 4: Demonstrate Boolean arithmetic
bool_example1 = True + True
bool_example2 = True + False
bool_example3 = False + False
bool_example4 = False + True + False
bool_example5 = True + False + True

print("")
print("═" * 40)
print("  Boolean Arithmetic Demo : ")
print("═" * 40)
print("")
print(f"True + True            = {bool_example1}")
print("")
print(f"True + False           = {bool_example2}")
print("")
print(f"False + False          = {bool_example3}")
print("")
print(f"False + True + False   = {bool_example4}")
print("")
print(f"True + False + True    = {bool_example5}")
print("")







# TODO 5: The floating-point precision issue
float_ex = 0.2 + 0.6
print("")
print("═" * 40)
print("  Floating Point Precision Issue : ")
print("═" * 40)
print("")
print(f"0.2 + 0.6   =   {float_ex}   (NOT EXACTLY 0.8!!!!!)")
print("")







# TODO 6: Show the difference between `==` and `is` using two examples.
Dog = ["Lucky", 2, 399.99]
Cat = ["Lucky", 2, 399.99]
Turtle = Dog
Compare_Results_One_Equals = (Dog==Cat)
Compare_Results_Two_Equals = (Dog==Turtle)
Compare_Results_One_Is = (Dog is Cat)
Compare_Results_Two_Is = (Dog is Turtle)
print("")
print("═" * 40)
print("  == VS IS : ")
print("═" * 40)
print("")
print("Dog = Lucky, 2, 399.99")
print("")
print("Cat = Lucky, 2, 399.99")
print("")
print("Turtle = Dog")
print("")
print("═" * 40)
print("  Equals Example : ")
print("═" * 40)
print("")
print(f"Dog_Name == Cat_Name ---> Lucky == Lucky                  :   {Compare_Results_One_Equals}")
print("")
print(f"Dog_Name == Turtle_Name_Possibility ---> Lucky == Lucky   :   {Compare_Results_Two_Equals}")
print("")
print("═" * 40)
print("  is Example : ")
print("═" * 40)
print("")
print(f"Dog_Name is Cat_Name ---> Lucky is Lucky                  :   {Compare_Results_One_Is}")
print("")
print(f"Dog_Name is Turtle_Name_Possibility ---> Lucky is Lucky   :   {Compare_Results_Two_Is}")
print("")
