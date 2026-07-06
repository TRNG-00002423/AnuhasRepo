"""
grade_processor.py : 
Involves :
- 
"""



# TODO : 
# Given a list of student scores, write a program that:

# 1. Uses a `for` loop with `enumerate` to process each score.
# 2. Assigns letter grades using `if/elif/else`.
# 3. Uses `continue` to skip any negative scores (invalid data).
# 4. Uses `break` if a score of `-999` is encountered (sentinel value — stop processing).
# 5. At the end, prints:
#    - Each student's grade
#    - Class average (excluding invalid scores)
#    - Highest and lowest grades
#    - Distribution count (how many A's, B's, C's, D's, F's)

# **Input data:**
# ```python
# scores = [88, 92, 75, -1, 63, 95, 81, 70, -5, 55, 100, 78, -999, 90, 85]
# ```

# **Expected behavior:** Process through index 11 (78), skip negatives, stop at -999.


print(" ")
print(" ")


def grade_processor(scores):

    keys = list()
    Grades = dict()
    Class_Total = 0
    Number_Of_Scores = 0
    Class_Average = 0
    Lowest = 101
    Highest = -1
    Number_Of_A_Grades = 0
    Number_Of_B_Grades = 0
    Number_Of_C_Grades = 0
    Number_Of_D_Grades = 0
    Number_Of_F_Grades = 0

    for score in enumerate(scores):
        Break_For_Bool = False

        if(score==-999):
            Break_For_Bool = True
            break

        # if(Break_For_Bool):
        #     break

        if (score[1]>0):
            keys.append(score)
            Number_Of_Scores = Number_Of_Scores + 1
            Class_Total += score[1]
            if (score[1]<Lowest):
                Lowest = score[1]
            if (score[1]>Highest):
                Highest = score[1]
            if (score[1]>=90):
                Grades[score[1]] = 'A'
                Number_Of_A_Grades = Number_Of_A_Grades + 1
            elif (score[1]>=80):
                Grades[score[1]] = 'B'
                Number_Of_B_Grades = Number_Of_B_Grades + 1
            elif (score[1]>=70):
                Grades[score[1]] = 'C'
                Number_Of_C_Grades = Number_Of_C_Grades + 1
            elif (score[1]>=60):
                Grades[score[1]] = 'D'
                Number_Of_D_Grades = Number_Of_D_Grades + 1
            else:
                Grades[score[1]] = 'F'
                Number_Of_F_Grades = Number_Of_F_Grades + 1

        def letterGrade(score):
            if (score>=90):
                return 'A'
            elif (score>=80):
                return 'B'
            elif (score>=70):
                return 'C'
            elif (score>=60):
                return 'D'
            else:
                return 'F'
            


        Lowest_Letter_Grade = letterGrade(Lowest)
        Highest_Letter_Grade = letterGrade(Lowest)
        Class_Average = Class_Total/Number_Of_Scores
        Class_Average_Letter_Grade = letterGrade(Class_Average)

        print("Student Grades : ")

        for value in Grades.values():
            print(value)

        print(" ")
        print(f"Class Average : {Class_Average} - {Class_Average_Letter_Grade}")
        print(" ")
        print(f"Highest Grade : {Highest} - {Highest_Letter_Grade}")
        print(" ")
        print(f"Lowest Grade : {Lowest} - {Lowest_Letter_Grade}")
        print(" ")
        print(f"Number Of A Grades : {Number_Of_A_Grades}")
        print(" ")
        print(f"Number Of B Grades : {Number_Of_B_Grades}")
        print(" ")
        print(f"Number Of C Grades : {Number_Of_C_Grades}")
        print(" ")
        print(f"Number Of D Grades : {Number_Of_D_Grades}")
        print(" ")
        print(f"Number Of F Grades : {Number_Of_F_Grades}")
            


print(" ")
print(" ")

scores = [88, 92, 75, -1, 63, 95, 81, 70, -5, 55, 100, 78, -999, 90, 85]
grade_processor(scores)
print(" ")
print(" ")
