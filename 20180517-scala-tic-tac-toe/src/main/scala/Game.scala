case class GameState(cells: Map[Position, CellState] =
                     Map(
                       LeftTop -> EmptyCell,
                       CentTop -> EmptyCell,
                       RightTop -> EmptyCell,
                       LeftCent -> EmptyCell,
                       CentCent -> EmptyCell,
                       RightCent -> EmptyCell,
                       LeftBottom -> EmptyCell,
                       CentBottom -> EmptyCell,
                       RightBottom -> EmptyCell,
                     ))

sealed abstract class CellState
case object EmptyCell extends CellState
case class Marked(player: Player) extends CellState

sealed abstract class Player
case object PlayerX extends Player
case object PlayerO extends Player

sealed abstract class Position
case object LeftTop extends Position
case object CentTop extends Position
case object RightTop extends Position
case object LeftCent extends Position
case object CentCent extends Position
case object RightCent extends Position
case object LeftBottom extends Position
case object CentBottom extends Position
case object RightBottom extends Position

object Game {
  def playX(gameState: GameState, position: Position): GameState = {
    var newCells = gameState.cells
    newCells += (position -> Marked(PlayerX))
    gameState.copy(cells = newCells)
  }
}


