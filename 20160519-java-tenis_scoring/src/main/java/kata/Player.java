package kata;

public class Player {

	private static final int POINT = 15;
	private static final int FORTY_POINT = 10;
	private static final int THIRTY_SCORE = 30;
	private static final int INITIAL_SCORE = 0;

    private int score = INITIAL_SCORE;

	public int getScore() {
		return score;
	}

	public void scores() {
		if (getScore() == THIRTY_SCORE) {
			score += FORTY_POINT;
            return;
		}

		score += POINT;
	}

}
