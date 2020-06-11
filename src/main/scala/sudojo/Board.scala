package sudojo

import cats.Show
import cats.implicits._
import mouse.all._

import scala.util.Try

case class Board private[sudojo] (fields: List[List[Option[Int]]]) {
  def get(x: Int, y: Int): Option[Int] = Try(fields(y)(x)).toOption.flatten
  def getValuesInCluster(x: Int, y: Int): Set[Int] = {
    val top = (x / 3) * 3
    val left = (y / 3) * 3
    ((top to (top + 2)).toList, (left to (left + 2)).toList).tupled.flatMap { case (i, j) =>
      get(i, j)
    }.toSet
  }
}

object Board {
  /** Parses a string representation like
   * 1-3-56-89
   * -56----2-
   * ...
   * where filled fields contain their digit, empty are represented by a dash and rows are separated by newlines.
   * BONUS: Ignore whitespace and cell/row separators as demonstrated in [[Solver.solve()]].
   * */
  def parse(repr: String): Option[Board] = Some(new Board(repr.split('\n').map(_.map(c => Try(s"$c".toInt).toOption).toList).toList))

  /**
   * Show instance for pretty printing in the format described in [[parse()]].
   * BONUS: Pretty print in the format given in [[Solver.solve()]].
   */
  implicit val show: Show[Board] = Show.show(board => board.fields.map(_.map(_.fold('-')(_.toChar)).mkString).mkString("\n"))
}
