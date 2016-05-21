package kata;

public class TennisGame {

	private static final int FORTY_SCORE = 40;

	private Player player1;
	private Player player2;

	public TennisGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public Player getWinner() {
		if (player1.getScore() > FORTY_SCORE) {
			return player1;
		} else if (player2.getScore() > FORTY_SCORE) {
			return player2;
		} else {
			return null;
		}
	}
}