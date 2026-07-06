import re

# TODO 1 : Convert a human-readable name to a test function name.
# Example:
#     format_test_name("Valid Login") → "test_valid_login"
#     format_test_name("  Search Results Page  ") → "test_search_results_page"

# Rules:
#     - Lowercase
#     - Spaces replaced with underscores
#     - Leading/trailing whitespace stripped
#     - Prefixed with "test_"
def format_test_name(name):    
    name = name.lower()
    test_name = "_".join(name.split())
    test_name = "test_" + test_name
    return test_name




# TODO 2 : Check if a string is a valid test function name.
# Rules:
#         - Must start with "test_"
#         - Must contain only lowercase letters, digits, and underscores
#         - Must be at least 6 characters (e.g., "test_x")

# Returns: bool
def is_valid_test_name(name):
    check = re.findall("[A-Z]", name)
    if (((len(name))>=6) & (name.startswith("test_"))):
        array_length = len(check)
        if (array_length==0):
            return True
    return False




#Test your functions :
assert format_test_name("Valid Login") == "test_valid_login"
assert format_test_name("  Search Results  ") == "test_search_results"
assert is_valid_test_name("test_login") == True
assert is_valid_test_name("login_test") == False
assert is_valid_test_name("test_") == False













# TODO 3 : Create a test result dictionary.
# Args:
#         name: Test name (required)
#         status: "pass" or "fail" (default: "pass")
#         duration_ms: Execution time in ms (default: 0)
#         error: Error message if failed (default: None)

# Returns:
#     dict with keys: name, status, duration_ms, error
def create_test_result(name, status="pass", duration_ms=0, error=None):
    return {"name": name, "status": status, "duration_ms": duration_ms, "error": error}

# TODO 4 : Format a duration value with the specified unit.
# Args:
#         ms: Duration in milliseconds
#         unit: "ms", "s", or "min" (default: "ms")

# Returns:
#     Formatted string like "1,200ms" or "1.20s" or "0.02min"
def format_duration(ms, unit="ms"):
    if (unit=="ms"):
        return f"{ms:,}{unit}"
    else:
        return f"{ms/1000:.2f}{unit}"



#Test your functions :
r1 = create_test_result("test_login")
assert r1 == {"name": "test_login", "status": "pass", "duration_ms": 0, "error": None}

r2 = create_test_result("test_checkout", status="fail", duration_ms=2300, error="Timeout")
assert r2["status"] == "fail"
assert r2["error"] == "Timeout"

assert format_duration(1200) == "1,200ms"
assert format_duration(1200, "s") == "1.20s"










# TODO 5 : Calculate statistics for any number of scores.
# Returns:
#         dict with keys: count, total, average, min, max

# Raises:
#     ValueError if no scores provided
def calculate_stats(*scores):
    count = len(scores)
    total = sum(scores)
    average = total/count
    minimum = min(scores)
    maximum = max(scores)
    return {"count": count, "total": total, "average": average, "min": minimum, "max": maximum}


# TODO 6 : Build a test configuration with defaults.
# Default config:
#         browser: "chrome"
#         headless: False
#         timeout: 30
#         retries: 0
#         base_url: "http://localhost:3000"

# Any **settings passed override the defaults.

# Returns: dict
def build_test_config(**settings):
    config = {"browser": "chrome", "headless": False, "timeout": 30, "retries": 0, "base_url": "http://localhost:3000"}
    config.update(settings)
    return config





#Test your functions :
stats = calculate_stats(85, 92, 78, 95, 88)
assert stats["count"] == 5
assert stats["average"] == 87.6
assert stats["min"] == 78
assert stats["max"] == 95

config = build_test_config(headless=True, timeout=60)
assert config["browser"] == "chrome"  # default
assert config["headless"] == True     # overridden
assert config["timeout"] == 60       # overridden











# TODO 7 : Analyze a list of test result dicts.
# Args:
#         *results: test result dicts (from create_test_result)

# Returns:
#     tuple of (passed_count, failed_count, pass_rate, avg_duration)
def analyze_results(*results):
    count = 0
    passed_count = 0
    failed_count = 0
    pass_rate = 0
    total_duration = 0
    avg_duration = 0
    for result in results:
        count=count+1
        if (result["status"]=="pass"):
            passed_count = passed_count+1
        else:
            failed_count = failed_count+1
        total_duration = total_duration + result["duration_ms"]
    pass_rate = (passed_count/count)*100
    avg_duration = total_duration/count
    return (passed_count, failed_count, pass_rate, avg_duration)

    

# TODO 8 : Generate a formatted test report string.
# Calls analyze_results() internally and formats the output.

# Returns: formatted multi-line string
def generate_report(*results):
    print("")
    print("═" * 55)
    print("|  Test Name          |    Duration    |    Status    | ")
    print("═" * 55)
    for result in results:
        if (result["duration_ms"]>=1000):
            print(f"|  {result["name"]:<16}      |    {result["duration_ms"]}     |   {result["status"]} ms    | ")
        else:
            print(f"|  {result["name"]:<16}      |    {result["duration_ms"]}      |   {result["status"]} ms    | ")
    print("═" * 55)    





#Test your functions :
results = [
    create_test_result("test_login", "pass", 1200),
    create_test_result("test_search", "pass", 850),
    create_test_result("test_checkout", "fail", 2300, "Timeout"),
    create_test_result("test_profile", "pass", 450),
]

passed, failed, rate, avg = analyze_results(*results)
assert passed == 3
assert failed == 1
assert rate == 75.0

generate_report(*results)