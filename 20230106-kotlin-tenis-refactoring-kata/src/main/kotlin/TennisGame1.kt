class TennisGame1(
    private val player1Name: String,
    private val player2Name: String
) : TennisGame {

    private var player1Score: Int = 0
    private var player2Score: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name)
            player1Score += 1
        else
            player2Score += 1
    }

    override fun getScore(): String {
        return if (scoresAreLevel()) {
            calculateLevelScore()
        } else if (scoresHaveNotPassedDeuce()) {
            translateScoreToTennisTerms(player1Score) + "-" + translateScoreToTennisTerms(player2Score)
        } else {
            val minusResult = player1Score - player2Score
            when {
                minusResult == 1 -> "Advantage player1"
                minusResult == -1 -> "Advantage player2"
                minusResult >= 2 -> "Win for player1"
                else -> "Win for player2"
            }
        }
    }

    private fun scoresHaveNotPassedDeuce() = player1Score < 4 && player2Score < 4

    private fun translateScoreToTennisTerms(playerScore: Int) = when (playerScore) {
        0 -> "Love"
        1 -> "Fifteen"
        2 -> "Thirty"
        3 -> "Forty"
        else -> ""
    }

    private fun calculateLevelScore() = when (player1Score) {
        0 -> "Love-All"
        1 -> "Fifteen-All"
        2 -> "Thirty-All"
        else -> "Deuce"
    }

    private fun scoresAreLevel() = player1Score == player2Score
}
