print(" ")
print(" ")

class Employee:

    company="Revature"
    emp_count=0

    def __init__(self, name, role):
        self.name = name        # Instance variable
        self.role = role
        Employee.emp_count+=1

    @classmethod
    def admin(cls, name):
        return cls(name, "admin")



emp1 = Employee("Oscar", "QA Engineer")
emp2 = Employee("Cody", "QA Engineer")
emp3=Employee.admin("Jasdhir")

print(emp1)
print(emp2)

print(emp1.name)
print(emp2.name)
print(emp1.role)
print(emp2.role)
print(emp1.company)
print(emp2.company)

print(emp1.emp_count)
print(emp2.emp_count)
print(Employee.emp_count)       # Class Variable


print(" ")
print(" ")