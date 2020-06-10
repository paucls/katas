from leap_year import is_leap_year


def test_leap_year_when_divisible_by_4():
    assert is_leap_year(1996) is True


def test_common_year_when_not_divisible_by_4():
    assert is_leap_year(2001) is False


def test_leap_year_when_divisible_by_4_and_400():
    assert is_leap_year(2000) is True


def test_common_year_when_divisible_by_4_but_not_by_100():
    assert is_leap_year(1900) is False
