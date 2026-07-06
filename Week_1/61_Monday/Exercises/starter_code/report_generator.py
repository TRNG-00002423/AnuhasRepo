"""
REPORT GENERATOR
"""


# TODO 1: Define 5 test results as variables (test name, duration in ms, status).
Test1 = ["test_login", 1200, "✅ PASS"]
Test2 = ["test_search", 850, "✅ PASS"]
Test3 = ["test_checkout", 2300, "❌ FAIL"]
Test4 = ["test_profile", 500, "✅ PASS"]
Test5 = ["test_logout", 500, "✅ PASS"]


# TODO 2: Print a formatted table using f-strings with alignment:
print("")
print("═" * 52)
print("|  Test Name       |    Duration    |    Status    | ")
print("═" * 52)
print(f"|  {Test1[0]}      |    {Test1[1]} ms     |   {Test1[2]}    | ")
print(f"|  {Test2[0]}     |    {Test2[1]} ms      |   {Test2[2]}    | ")
print(f"|  {Test3[0]}   |    {Test3[1]} ms     |   {Test3[2]}    | ")
print(f"|  {Test4[0]}    |    {Test4[1]} ms      |   {Test4[2]}    | ")
print(f"|  {Test5[0]}     |    {Test5[1]} ms      |   {Test5[2]}    | ")
print("═" * 52)