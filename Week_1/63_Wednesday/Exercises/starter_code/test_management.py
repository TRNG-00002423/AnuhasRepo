"""
test_management.py : 
Involves :
- 
"""


import re

# TODO 1 : represents a single test


class TestCase:
    """Represents a single test case.

    Class Attributes:
        total_created (int): Count of all TestCase objects ever created

    Instance Attributes:
        name (str): Test name (e.g., "test_login_valid")
        description (str): What this test verifies
        priority (str): "high", "medium", or "low" (default: "medium")
        tags (list): Labels like ["smoke", "regression"]
    """
    # TODO: Implement __init__, run(), and a class method

    total_created = 0
    

    def __init__(self, name, description, priority : "medium", tags : []):

        check = TestCase.is_valid_name(name)

        if (check==True):
            self.name = name
            self.description = description
            self.priority = priority
            self.tags = tags
        else:
            raise ValueError("Invalid Test Name")

    def run(self):
        """TODO : Simulate running the test. Return True for pass, False for fail.
        For now, use: return "fail" not in self.name
        """
        
        pass  # TODO

    @classmethod
    def from_dict(cls, data):
        """TODO : Create a TestCase from a dictionary.
        Example: TestCase.from_dict({"name": "test_login", "priority": "high"})
        """

        
        # name=data.get('name')
        # try:
        #     description = data.get('description')
        # except SyntaxError as e:
        #     print("Caught SyntaxError")
        #     print(f"Error details: {e.msg} on line {e.lineno}")
        # try:
        #     priority = data.get('priority')
        # except SyntaxError as e:
        #     print("Caught SyntaxError")
        #     print(f"Error details: {e.msg} on line {e.lineno}")
        # tags = data.get('tags')
        

        # if ((len(description)>0) & (len(priority)>0) & (len(tags)>0) ):
        #     return cls(
        #         name=name,
                # description =description
                # priority=priority
        #         tags=tags
        #     )

        # return cls(
        #     name=data.get('name'),
        #     tags = data.get('tags')
        # )
    
        return cls(
            name=data.get('name'),           
            description = data.get('description', ""),
            priority = data.get('priority','medium'),
            tags = data.get('tags', [])
        )
    


    @staticmethod
    def is_valid_name(name):
        """ TODO : Check if name starts with 'test_' and has no spaces."""
        
        has_whitespace = any(char.isspace() for char in name)
        if (has_whitespace==True):
            if (name.startswith("test_")):
                return True
            
        return false
    





class TestResult:
    """The outcome of running a single test.

    Instance Attributes:
        test_name (str): Which test was run
        status (str): "pass" or "fail"
        duration_ms (float): How long it took
        error_message (str or None): Error details if failed
    """
    # TODO: Implement
    def __init__(self, test_name, status, duration_ms, error_message=None):
        self.test_name=test_name
        self.status=status
        self.duration_ms=duration_ms
        self.error_message=error_message

    def summary(self):
        """TODO :Return a one-line summary like: '✅ test_login (120ms)'"""
        if (self.status=="pass"):
             test_status = '✅'
        else:
            test_status = '❌'
        return f"{test_status} : {self.test_name} {self.duration_ms}"





class TestSuite:
    """A collection of test cases.

    Instance Attributes:
        name (str): Suite name
        tests (list): List of TestCase objects

    Methods:
        add_test(test): Add a TestCase
        remove_test(name): Remove by name
        get_by_priority(priority): Return tests matching the priority
        count(): Return number of tests
    """

    def __init__(self, name, tests=None):
        self.name = name
        self.tests = tests

    def add_test(test):
        TestCase.total_created = TestCase.total_created + 1
        self.tests.append(test)

    
    def remove_test(name):
        for test in self.tests:
            if (test.name == name):
                self.tests.remove(test)
                return True
        return False
    
    def get_by_priority(priority):

        tests_by_priority = ()

        for test in self.tests:
            if (test.priority == priority):
                tests_by_priority += test
    
    def count():
        return TestCase.total_created
    

  
  







class TestRunner:
    """Executes a TestSuite and collects results.

    TODO : Methods:
        run(suite): Run all tests in a suite, return list of TestResult
        summary(results): Print a formatted summary
    """

    def run(self, suite):
        """Run each test in the suite and return a list of TestResults."""
        import time
        import random
        results = []
        for test in suite.tests:
            start = time.time()
            passed = test.run()
            duration = (time.time() - start) * 1000
            # Simulate varying duration
            duration += random.uniform(50, 500)
            result = TestResult(
                test.name,
                "pass" if passed else "fail",
                round(duration, 1),
                None if passed else f"{test.name} assertion failed"
            )
            results.append(result)
        return results
    
    def summary(self, results):
        passed_number_of_tests = sum(1 for result in results if result.status == "pass")
        failed_number_of_tests = sum(1 for result in results if result.status == "fail")