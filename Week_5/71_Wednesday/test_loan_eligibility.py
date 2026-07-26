import pytest

from loan_eligibility import is_loan_eligible


def test_happy_path_eligible():
    """ 
        All conditions True -> Eligible. 
        One Test, Many Uncovered Branches.
    """
    # assert is_loan_eligible(age=30, income=50000, credit_score=700, has_existing_loan=True) == "Eligible"
    assert is_loan_eligible(30, 50000, 700, True) == "Eligible"


# def test_ineligible_age_too_young():
#     """ 
#         Age < 18 -> Ineligible: Age
#     """
#     assert is_loan_eligible(17, 50000, 700, True) == "Ineligible: Age"

# def test_ineligible_age_too_old():
#     """ 
#         Age > 65 -> Ineligible: Age
#     """
#     assert is_loan_eligible(66, 50000, 700, True) == "Ineligible: Age"

def test_ineligible_annual_income():
    """ 
        Income < 25000 -> Ineligible: Income
    """
    assert is_loan_eligible(30, 20000, 700, True) == "Ineligible: Income"

def test_ineligible_credit_score():
    """ 
        Credit Score < 600 -> Ineligible: Credit Score
    """
    assert is_loan_eligible(30, 50000, 500, True) == "Ineligible: Credit Score"

def test_ineligible_employment_status():
    """ 
        Not Employed -> Ineligible: Employment Status
    """
    assert is_loan_eligible(30, 50000, 700, False) == "Ineligible: Employment Status"


# def test_happy_path_eligible():
#     """ 
#         All conditions True -> Eligible. 
#         One Test, Many Uncovered Branches.
#     """
#     assert is_loan_eligible(30, 30000) == "Eligible"


# Boundry Value Anyalysis Example
# BVA Additions : Boundries Of The Age Range
@pytest.mark.parametrize("age, expected",[
    (17, "Ineligible: Age"), # Below Lower Bound
    (18, "Eligible"), # Lower Bound
    (65, "Eligible"),# Upper Bound
    (66, "Ineligible: Age"), # Above Upper Bound
])

def test_age_boundarie_values(age, expected):
    """ 
        Test Age Boundaries for Eligibility
    """
    result = is_loan_eligible(age, 30000, 700, True)
    # assert result == expected, f"Age: {age}, Expected: {expected}, Got: {result}"
    assert result == expected, f"Expected {expected} for age {age}, but got {result}"