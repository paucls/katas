import functools


class BowlingGame:

    def __init__(self, rolls):
        self._rolls = rolls

    def score(self):
        score = 0
        roll_index = 0

        for _ in range(20):
            score += self._rolls[roll_index]
            roll_index += 1

        return score
