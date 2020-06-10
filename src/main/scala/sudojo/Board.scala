package sudojo

import cats.Show

case class Board private (fields: /* replace me with something smart */ Nothing)

object Board {
  /** Parses a string representation like
   * 1-3-56-89
   * -56----2-
   * ...
   * where filled fields contain their digit, empty are represented by a dash and rows are separated by newlines.
   * BONUS: Ignore whitespace.
   * */
  def parse(repr: String): Option[Board] = ???

  /**
   * Show instance for pretty printing in the format described in [[parse()]].
   * BONUS: Pretty print in the format given in [[Solver.solve()]].
   */
  implicit val show: Show[Board] = Show.show(_ => "Implement me")
}
