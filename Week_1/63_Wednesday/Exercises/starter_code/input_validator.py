"""
input_validator.py : 
Involves :
- 
"""

# TODO :
# Write a function `validate_password(password)` that checks:
# - At least 8 characters long
# - Contains at least one uppercase letter
# - Contains at least one lowercase letter
# - Contains at least one digit
# - Contains at least one special character (`!@#$%^&*`)

# Return a dict with:
# ```python
# {
#     "valid": True/False,
#     "errors": ["list of failure reasons"]
# }
# ```

# **Test cases:**
# ```python
# validate_password("Abc123!x")    # valid
# validate_password("abc")         # too short, no upper, no digit, no special
# validate_password("ABCDEFGH")    # no lower, no digit, no special
# validate_password("ABCDefgh1!")  # valid
# ``` 

import re


print(" ")
print(" ")

def validate_password(password) :
    valid = False
    errors = list()
    if (len(password)>=8):
        if(re.search(r'[A-Z]', password)):
            if(re.search(r'[a-z]', password)):
                if(re.search(r'[0-9]', password)):
                    if(re.search(r'[!@#$%^&*]', password)):
                        valid = True    

    if (len(password)<8):
        errors.append("Too Short")

    if ((bool(re.search(r'[A-Z]', password)))==False):
        errors.append("No Uppercase Character")
            
    if((bool(re.search(r'[a-z]', password)))==False):
        errors.append("No Lowercase Character")
                
    if((bool(re.search(r'[0-9]', password)))==False):
        errors.append("No Digit")
        
    if((bool(re.search(r'[!@#$%^&*]', password)))==False):
        errors.append("No Special Character")
        
    print(f"Password: {password}, \nValid: {valid}, \nErrors: {errors}")
    print("")
    return {"valid": valid, "errors": errors}
                    




is_Valid = validate_password("Abc123!x")    # valid

is_Valid = validate_password("abc")         # too short, no upper, no digit, no special

is_Valid = validate_password("ABCDEFGH")    # no lower, no digit, no special

is_Valid = validate_password("ABCDefgh1!")  # valid

print(" ")
print(" ")