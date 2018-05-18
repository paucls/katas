import org.scalatest.FunSpec

class GameTests extends FunSpec {

  describe("GameState") {

    it("starts with 9 empty cells") {
      val gameState = GameState()

      assert(gameState.cells.size == 9)
//      assert(gameState.cells.forall({ cell => cell == EmptyCell }))
    }

    it("marks a cell when a player plays"){
      val gameState = GameState()

      val newGameState = Game.playX(gameState, LeftTop)

      assert(newGameState.cells(LeftTop).equals(Marked(PlayerX)))
      assert(gameState == GameState())
    }
  }

}
