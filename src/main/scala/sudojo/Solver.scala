package sudojo

object Solver {

  /**
   * Solve the board by filling all empty fields. Returns None if board can't be solved.
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
  def solve(board: Board): Option[Board] = ???

  /**
   * BONUS: Return ALL possible solutions for a given board.
   */
  def solutions(board: Board): List[Board] = solve(board).toList // replace me

}
