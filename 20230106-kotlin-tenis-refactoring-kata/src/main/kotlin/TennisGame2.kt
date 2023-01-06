class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {
    private var player1Points: Int = 0
    private var player2Points: Int = 0

    override fun getScore(): String {
        var score = ""
        var player1Result: String = ""
        var player2Result: String = ""

        if (player1Points == player2Points && player1Points < 4) {
            if (player1Points == 0)
                score = "Love"
            if (player1Points == 1)
                score = "Fifteen"
            if (player1Points == 2)
                score = "Thirty"
            score += "-All"
        }
        if (player1Points == player2Points && player1Points >= 3)
            score = "Deuce"

        if (player1Points > 0 && player2Points == 0) {
            if (player1Points == 1)
                player1Result = "Fifteen"
            if (player1Points == 2)
                player1Result = "Thirty"
            if (player1Points == 3)
                player1Result = "Forty"

            player2Result = "Love"
            score = "$player1Result-$player2Result"
        }
        if (player2Points > 0 && player1Points == 0) {
            if (player2Points == 1)
                player2Result = "Fifteen"
            if (player2Points == 2)
                player2Result = "Thirty"
            if (player2Points == 3)
                player2Result = "Forty"

            player1Result = "Love"
            score = "$player1Result-$player2Result"
        }

        if (player1Points > player2Points && player1Points < 4) {
            if (player1Points == 2)
                player1Result = "Thirty"
            if (player1Points == 3)
                player1Result = "Forty"
            if (player2Points == 1)
                player2Result = "Fifteen"
            if (player2Points == 2)
                player2Result = "Thirty"
            score = "$player1Result-$player2Result"
        }
        if (player2Points > player1Points && player2Points < 4) {
            if (player2Points == 2)
                player2Result = "Thirty"
            if (player2Points == 3)
                player2Result = "Forty"
            if (player1Points == 1)
                player1Result = "Fifteen"
            if (player1Points == 2)
                player1Result = "Thirty"
            score = "$player1Result-$player2Result"
        }

        if (player1Points > player2Points && player2Points >= 3) {
            score = "Advantage player1"
        }

        if (player2Points > player1Points && player1Points >= 3) {
            score = "Advantage player2"
        }

        if (player1Points >= 4 && player2Points >= 0 && player1Points - player2Points >= 2) {
            score = "Win for player1"
        }
        if (player2Points >= 4 && player1Points >= 0 && player2Points - player1Points >= 2) {
            score = "Win for player2"
        }
        return score
    }

    override fun wonPoint(playerName: String) {
        if (playerName === player1Name) {
            player1Points++
        } else {
            player2Points++
        }
    }
}
