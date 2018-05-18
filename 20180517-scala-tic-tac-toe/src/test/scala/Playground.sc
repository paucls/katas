sealed abstract class CellState
case object EmptyCell extends CellState
case object Marked extends CellState

sealed abstract class Mark(val player: Player)

sealed abstract class Player
case object PlayerX extends Player
case object PlayerY extends Player

val emptyCell: CellState = EmptyCell
val playedByX: CellState = Marked(PlayerX)
val playedByY: CellState = Marked(PlayerY)