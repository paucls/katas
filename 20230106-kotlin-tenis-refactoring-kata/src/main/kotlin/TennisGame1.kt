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
        if (scoresAreLevel()) {
            return calculateLevelScore()
        } else if (player1Score >= 4 || player2Score >= 4) {
            val minusResult = player1Score - player2Score
            if (minusResult == 1)
                return "Advantage player1"
            else if (minusResult == -1)
                return "Advantage player2"
            else if (minusResult >= 2)
                return "Win for player1"
            else
                return "Win for player2"
        } else {
            var score = ""
            when (player1Score) {
                0 -> score += "Love"
                1 -> score += "Fifteen"
                2 -> score += "Thirty"
                3 -> score += "Forty"
            }
            score += "-"
            when (player2Score) {
                0 -> score += "Love"
                1 -> score += "Fifteen"
                2 -> score += "Thirty"
                3 -> score += "Forty"
            }
            return score
        }
    }

    private fun calculateLevelScore() = when (player1Score) {
        0 -> "Love-All"
        1 -> "Fifteen-All"
        2 -> "Thirty-All"
        else -> "Deuce"
    }

    private fun scoresAreLevel() = player1Score == player2Score
}
