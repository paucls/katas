from shapes import Paper, Rock, Scissors


def test_a_paper_beats_a_rock():
    assert Paper().beats(Rock()) is True


def test_a_paper_does_not_beat_scissors():
    assert Paper().beats(Scissors()) is False


def test_a_rocks_beats_scissors():
    assert Rock().beats(Scissors()) is True
