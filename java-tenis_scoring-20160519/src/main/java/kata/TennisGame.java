package kata;

public class TennisGame {

	private Player player1;
	private Player player2;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public Player getWinner() {
		if (player1.getScore() > 40) {
			return player1;
		}
		return player2;
	}
}
