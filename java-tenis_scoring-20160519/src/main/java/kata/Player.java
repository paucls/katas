package kata;

public class Player {

	public static final int POINT = 15;
	public static final int FORTY_POINT = 10;
	public static final int THIRTY_SCORE = 30;
    public static final int INITIAL_SCORE = 0;

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
