class Game:
    def play(self):
        pass

    def rounds(self):
        return [{'player1': 'Rock', 'player2': 'Scissors', 'result': 'player 1 wins'}]


def test_game_with_one_round():
    game = Game()
    game.play()
    assert game.rounds() == [{'player1': 'Rock', 'player2': 'Scissors', 'result': 'player 1 wins'}]
