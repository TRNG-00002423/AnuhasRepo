"""
Business Rules For Shipping Tiers:
    - Orders over 100 dollars with priority flag -> EXPRESS SHIPPING
    - Orders over 100 dollars without priority flag -> STANDARD SHIPPING
    - Orders 100 dollars oor under -> NO_FREE_SHIPPING (customer pays)
"""


def get_shipping_tier (order_total: float, priority: bool) -> str:
    """
        Return The Shipping Tier For An Order

        Args :
            order_total: Total order value in dollars
            priority : True if the customer has a priority membership

        Returns :
            'EXPRESS', 'STANDARD', or 'NO_FREE_SHIPPING'       
    """

    if order_total > 100:
        if priority:
            return "EXPRESS"
        return "STANDARD"
    return "NO_FREE_SHIPPING"

