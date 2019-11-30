from shapes import Paper, Rock, Scissors


def test_a_paper_beats_a_rock():
    paper = Paper()
    rock = Rock()
    assert paper.beats(rock) is True


def test_a_paper_does_not_beat_scissors():
    assert Paper().beats(Scissors()) is False
