"""
guessing_game.py : 
Involves :
- 
"""



# TODO : 
# 1. Generate a random number between 1 and 100.
# 2. Give the user 7 attempts to guess it.
# 3. After each guess, tell them "Too high!" or "Too low!".
# 4. Track the number of attempts used.
# 5. If they guess correctly: print a congratulations message with attempts used.
# 6. If they use all 7 attempts: reveal the answer.
# 7. Use the `while` loop with `else` clause.

# **Hint:** `import random; answer = random.randint(1, 100)`

import random


answer = random.randint(1, 100)
Number_Of_Guesses = 7
Number_Of_Attempts = 0
Guessed_Correctly = False
print(" ")
print(" ")

while (Number_Of_Guesses>0):
    Guess = int(input(f"Please guess a random integer between 1 - 100. You have {Number_Of_Guesses} guesses left : "))
    Number_Of_Attempts = Number_Of_Attempts + 1
    if (Guess==answer):
        print(f"Congratulations! You guessed correctly, using only {Number_Of_Attempts} attempts !!")
        Guessed_Correctly = True
        break
    elif (Guess<answer):
        print("TOO LOW !!")
    else:
        print("TOO HIGH !!")

if ((Number_Of_Guesses==0) & (Guessed_Correctly==False)):
    print(f"Nice Try! The Correct Answer Was : {answer}")

    
print(" ")
print(" ")