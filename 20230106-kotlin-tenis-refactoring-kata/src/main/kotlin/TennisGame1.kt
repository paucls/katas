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
        var score = ""
        var tempScore = 0
        if (scoresAreLevel()) {
            score = calculateLevelScore(score)
        } else if (player1Score >= 4 || player2Score >= 4) {
            val minusResult = player1Score - player2Score
            if (minusResult == 1)
                score = "Advantage player1"
            else if (minusResult == -1)
                score = "Advantage player2"
            else if (minusResult >= 2)
                score = "Win for player1"
            else
                score = "Win for player2"
        } else {
            for (i in 1..2) {
                if (i == 1)
                    tempScore = player1Score
                else {
                    score += "-"
                    tempScore = player2Score
                }
                when (tempScore) {
                    0 -> score += "Love"
                    1 -> score += "Fifteen"
                    2 -> score += "Thirty"
                    3 -> score += "Forty"
                }
            }
        }
        return score
    }

    private fun calculateLevelScore(score: String): String {
        var score1 = score
        when (player1Score) {
            0 -> score1 = "Love-All"
            1 -> score1 = "Fifteen-All"
            2 -> score1 = "Thirty-All"
            else -> score1 = "Deuce"
        }
        return score1
    }

    private fun scoresAreLevel() = player1Score == player2Score
}
