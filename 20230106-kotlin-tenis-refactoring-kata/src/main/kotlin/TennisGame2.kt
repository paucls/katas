class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {
    private var player1Points: Int = 0
    private var player2Points: Int = 0

    var P1res: String = ""
    var P2res: String = ""

    override fun getScore(): String {
        var score = ""
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
                P1res = "Fifteen"
            if (player1Points == 2)
                P1res = "Thirty"
            if (player1Points == 3)
                P1res = "Forty"

            P2res = "Love"
            score = "$P1res-$P2res"
        }
        if (player2Points > 0 && player1Points == 0) {
            if (player2Points == 1)
                P2res = "Fifteen"
            if (player2Points == 2)
                P2res = "Thirty"
            if (player2Points == 3)
                P2res = "Forty"

            P1res = "Love"
            score = "$P1res-$P2res"
        }

        if (player1Points > player2Points && player1Points < 4) {
            if (player1Points == 2)
                P1res = "Thirty"
            if (player1Points == 3)
                P1res = "Forty"
            if (player2Points == 1)
                P2res = "Fifteen"
            if (player2Points == 2)
                P2res = "Thirty"
            score = "$P1res-$P2res"
        }
        if (player2Points > player1Points && player2Points < 4) {
            if (player2Points == 2)
                P2res = "Thirty"
            if (player2Points == 3)
                P2res = "Forty"
            if (player1Points == 1)
                P1res = "Fifteen"
            if (player1Points == 2)
                P1res = "Thirty"
            score = "$P1res-$P2res"
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

    override fun wonPoint(player: String) {
        if (player === player1Name) {
            player1Points++
        } else {
            player2Points++
        }
    }
}
