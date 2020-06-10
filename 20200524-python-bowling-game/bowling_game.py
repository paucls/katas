import functools

NUM_FRAMES = 10

ALL_PINS_IN_FRAME = 10


class BowlingGame:

    def __init__(self, rolls):
        self._rolls = rolls

    def score(self):
        score = 0
        roll_index = 0

        for _ in range(NUM_FRAMES):
            if self._rolls[roll_index] + self._rolls[roll_index + 1] == ALL_PINS_IN_FRAME:
                score += self.calculate_score_for_spare(roll_index)
            else:
                score += self._rolls[roll_index] + self._rolls[roll_index + 1]
            roll_index += 2

        return score

    def calculate_score_for_spare(self, roll_index):
        return ALL_PINS_IN_FRAME + self._rolls[roll_index + 2]
