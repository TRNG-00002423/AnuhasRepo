"""
    Loan Assessment Module

    Business Rules:
     1. Age must be between 18 and 65 years (inclusive).
     2. Annual income must be at least $25,000.
     3. Credit score must be at least 600.
     4. Applicant must be currently employed.

    returns a string result indicating eligibility
    or the first disqualifying condition encountered (short-circuit evaluation).
"""

# def is_loan_eligible(age: int, annual_income: float):
#     if age > 18 and annual_income > 25000:
#         return "Eligible"
#     return "Ineligible"




def is_loan_eligible(age: int, annual_income: float, credit_score: int, is_employed: bool) -> str:
    """
    Assess loan eligibility based on/against the provided criteria.
    
    Returns:
        'Eligible', 'Ineligible: Age', 'Ineligible: Income', 'Ineligible: Credit Score', or 'Ineligible: Employment Status'
    """

    if age < 18 or age > 65:
        return "Ineligible: Age"
    if annual_income < 25000:
        return "Ineligible: Income"
    if credit_score < 600:
        return "Ineligible: Credit Score"
    if not is_employed:
        return "Ineligible: Employment Status"
    
    return "Eligible"