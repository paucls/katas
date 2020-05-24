class BowlingGame:

    def __init__(self, rolls):
        self._rolls = rolls

    def score(self):
        return 0


def test_should_have_score_0_for_gutter_game():
    rolls = [0, 0, 0, 0, 0,
             0, 0, 0, 0, 0,
             0, 0, 0, 0, 0,
             0, 0, 0, 0, 0]

    score = BowlingGame(rolls).score()

    assert score == 0
