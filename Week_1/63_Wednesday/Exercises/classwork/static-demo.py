print(" ")
print(" ")



class MathUtil:

    @staticmethod           # Neither Self Nor Cls
    def is_even(n):
        return n%2==0
    
    # def cel_to_fer(c):
    #     return c*(9/5)+32
    

# mu = MathUtil()
# print(f"{mu.is_even(20)}")

print(MathUtil.is_even(21))

print(" ")
print(" ")