from shapes import Paper, Rock, Scissors


def test_a_paper_beats_a_rock():
    assert Paper().beats(Rock())


def test_a_paper_does_not_beat_scissors():
    assert not Paper().beats(Scissors())


def test_a_rock_beats_scissors():
    assert Rock().beats(Scissors())


def test_a_rock_does_not_beat_paper():
    assert not Rock().beats(Paper())
