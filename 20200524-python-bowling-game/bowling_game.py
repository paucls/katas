import functools


class BowlingGame:

    def __init__(self, rolls):
        self._rolls = rolls

    def score(self):
        score = 0
        roll_index = 0

        for _ in range(10):
            if self._rolls[roll_index] + self._rolls[roll_index + 1] == 10:
                score += 10 + self._rolls[roll_index + 2]
            else:
                score += self._rolls[roll_index] + self._rolls[roll_index + 1]
            roll_index += 2

        return score
