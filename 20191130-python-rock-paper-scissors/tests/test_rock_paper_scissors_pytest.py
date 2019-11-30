from shapes import Paper, Rock


def test_a_paper_beats_a_rock():
    paper = Paper()
    rock = Rock()
    assert paper.beats(rock) is True
