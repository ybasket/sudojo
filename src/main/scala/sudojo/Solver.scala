package sudojo

import cats.implicits._

import scala.collection.immutable.{AbstractSet, SortedSet}

object Solver {

  /**
   * Solve the board by filling all empty fields. Returns None if board can't be solved. If the board is ambiguous,
   * any solution is acceptable.
   * Sudoku rules:
   * - fields need to be filled with number from 1 to 9
   * - each line must not contain a number twice
   * - each row must not contain a number twice
   * - each cluster of 9 cells (3x3, aligned on multiples of 3) must not contain a number twice
   *
   * Example for the top-left cell (cells with X affected by rules, O not)
   * X X X | X X X | X X X
   * X X X | O O O | O O O
   * X X X | O O O | O O O
   * =====================
   * X O O | O O O | O O O
   * X O O | O O O | O O O
   * X O O | O O O | O O O
   * =====================
   * X O O | O O O | O O O
   * X O O | O O O | O O O
   * X O O | O O O | O O O
   */
  type Internal = Map[(Int, Int), Set[Int]]

  def solve(board: Board): Option[Board] = {
    var oldMap: Internal = null
    var newMap = makeMap(board)
    var newBoard: Board = null
    while(oldMap != newMap) {
      newBoard = new Board((0 to 8).toList.map(y => (0 to 8).toList.map(x => newMap(x -> y) match {
        case set if set.size === 1 => set.headOption
        case _ => None
      })))
      oldMap = newMap
      newMap = makeMap(newBoard)
    }
    return newBoard.some
  }

  def makeMap(board: Board): Internal = (0 to 8).toList.flatMap(x => (0 to 8).toList.tupleRight(x)).map { case (x, y) =>
    (x, y) -> board.get(x, y).map(Set(_)).getOrElse(possibleValues(x, y, board))
  }.toMap

  def possibleValues(x: Int, y: Int, board: Board): Set[Int] = board.get(x, y) match {
    case Some(value) => Set(value)
    case None =>
      val complement = (0 to 8).toList.flatMap(i => List(board.get(x, i), board.get(i, y))).flatten.toSet
      val hereMaybe = board.getValuesInCluster(x, y)
      (1 to 9).toSet.diff(complement union hereMaybe)
  }

  /**
   * BONUS: Return ALL possible solutions for a given board.
   */
  def solutions(board: Board): List[Board] = solve(board).toList // replace me

}
