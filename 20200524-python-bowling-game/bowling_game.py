import functools


class BowlingGame:

    def __init__(self, rolls):
        self._rolls = rolls

    def score(self):
        return functools.reduce(lambda a, b: a + b, self._rolls)
