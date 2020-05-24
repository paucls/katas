from bowling_game import BowlingGame


def test_should_have_score_0_for_gutter_game():
    bowling_game = BowlingGame([0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                0, 0, 0, 0, 0, 0, 0, 0, 0, 0])
    assert bowling_game.score() == 0


def test_should_have_score_20_for_game_with_1_pin_knocked_in_each_roll():
    bowling_game = BowlingGame([1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                                1, 1, 1, 1, 1, 1, 1, 1, 1, 1])
    assert bowling_game.score() == 20
