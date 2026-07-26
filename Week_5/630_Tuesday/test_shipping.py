import pytest
from TUESDAY.shipping import get_shipping_tier


def test_express_returned_for_large_priority_order():
    assert get_shipping_tier(150, True) == "EXPRESS"

def test_standard_returned_for_large_non_priority_order():
    assert get_shipping_tier(150, False) == "STANDARD"

def test_no_free_shipping_returned_for_small_order():
    assert get_shipping_tier(50, False) == "NO_FREE_SHIPPING"


# # 100 PERCENT COVERAGE DOES NOT IMPLY 100 PERCENT ACCURACY
# def test_wrong_oracle_still_100_percent():
#     result = get_shipping_tier(150, priority=True)
#     # assert result == "EXPRESS"
#     assert result == "STANDARD" # This assertion is intentionally incorrect to demonstrate a failing test case

