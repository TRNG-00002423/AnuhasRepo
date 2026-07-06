"""
decorators.py : 
Involves :
- 
"""

import logging
import time
from functools import wraps


print(" ")
print(" ")

# TODO: Implement Decorator that measures and prints execution time.
# Output format: "⏱️ {func_name} completed in {seconds:.4f}s"

def timer(func):

    @wraps(func)
    def wrapper(*args, **kwargs):

        # Record Start Time
        start_time= time.perf_counter()

        # Execute The Original Function
        result = func(*args, **kwargs)

        # Record The End Time
        end_time = time.perf_counter()

        # Calculate And Print The Duration
        execution_time = end_time - start_time
        print(f"⏱️  Function : {func.__name__} completed in {execution_time:.4f}s") 

        return result
    
    return wrapper
    

print(" ")
print(" ")

# **Test:**
@timer
def slow_operation():
    time.sleep(0.5)
    return "done"

result = slow_operation()
# Should print: ⏱️ slow_operation completed in 0.50XXs
assert result == "done"
assert slow_operation.__name__ == "slow_operation"  # @wraps preserves metadata




# TODO: Implement (3-layer nesting: factory → decorator → wrapper)
# Parameterized decorator that retries on failure.

#     Args:
#         max_attempts: Maximum number of tries
#         delay: Seconds between retries
#         exceptions: Tuple of exception types to catch

#     Prints progress: "⚠️ Attempt {n}/{max}: {error}. Retrying in {delay}s..."
#     On final failure: "💥 {func_name} failed after {max} attempts"
def retry(max_attempts=3, delay=0.5, exceptions=(Exception,)):
    def decorator(func):
        @wraps(func)
        def wrapper(*args,**kwargs):
            attempts=0
            while attempts < max_attempts:
                try:
                    return func(*args, **kwargs)
                except exceptions as e:
                    attempts = attempts + 1
                    print(f"Attempt : {attempts} failed. Retrying in {delay} seconds ... ERROR : {e}")
                    if attempts >= max_attempts:
                        print("Max attempts reeached. Raising exception.")
                        raise
                    time.sleep(delay)
        return wrapper
    return decorator

print(" ")
print(" ")
# **Test:**


attempt_count = 0

@retry(max_attempts=3, delay=0.1)
def flaky_function():
    global attempt_count
    attempt_count += 1
    if attempt_count < 3:
        raise ConnectionError("Server unavailable")
    return "success"

result = flaky_function()
assert result == "success"



print(" ")
print(" ")

# TODO : Decorator that logs function calls with arguments and return value.
    # Output:
    #     "📞 Calling func_name(arg1, arg2, key=val)"
    #     "✅ func_name → return_value"

# Create Basic Logging To Output To The Console
logging.basicConfig(level=logging.INFO, format="%(levelname)s: %(message)s")

def log_calls(func):
  
  @wraps(func)
  def wrapper(*args, **kwargs):
      
      # Capture And Log Incomming Arguments Before Execution
      logging.info(f"Calling  : {func.__name__} with args = {args}, kwargs = {kwargs}")

      # Execute The Actual Function And Capture Its Output
      result = func(*args, **kwargs)

      # Log The Captured Return Value
      logging.info(f"{func.__name__} returned : {result}")

      # Return The Result So The Function Behaves Normally
      return result


# Configure Logging
logging.basicConfig(level=logging.INFO, format="%(levelname)s: %(message)s")
logger = logging.getLogger("DataProcessing")

# TODO : Process data with timing, logging, and retry.
@timer
@log_calls
@retry(max_attempts=2, delay=0.1)
def process_data(data):
    if not data:
        raise ValueError("Empty data")
    return [x * 2 for x in data]

result = process_data([1, 2, 3])