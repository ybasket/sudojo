package sudojo

import cats.implicits._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BoardTest extends AnyFlatSpec with Matchers {

  // Note this board isn't valid as of the rules
  val filledBoardRepr =
    """123456789
      |912345678
      |891234567
      |789123456
      |678912345
      |567891234
      |456789123
      |345678912
      |234567891""".stripMargin

  val emptyBoardRepr =
    """---------
      |---------
      |---------
      |---------
      |---------
      |---------
      |---------
      |---------
      |---------""".stripMargin

  "Boards" should "be parsed successfully" in {
    Board.parse(filledBoardRepr) should not be empty
    Board.parse(emptyBoardRepr) should not be empty
  }

  it should "round-trip parsing and pretty-printing successfully" in {
    show"${Board.parse(filledBoardRepr).get}" shouldBe filledBoardRepr
    show"${Board.parse(emptyBoardRepr).get}" shouldBe emptyBoardRepr
  }

}
