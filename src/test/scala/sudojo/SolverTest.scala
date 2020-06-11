package sudojo

import cats.implicits._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SolverTest extends AnyFlatSpec with Matchers {

  "The Solver" should "find the solution for an easy Sudoku" in {
    val inputRepr =
      """--3-2-6--
        |9--3-5--1
        |--18-64--
        |--81-29--
        |7-------8
        |--67-82--
        |--26-95--
        |8--2-3--9
        |--5-1-3--""".stripMargin

    val solutionRepr =
      """483921657
        |967345821
        |251876493
        |548132976
        |729564138
        |136798245
        |372689514
        |814253769
        |695417382""".stripMargin
    (Board.parse(inputRepr) >>= Solver.solve) shouldBe Board.parse(solutionRepr)
  }

  it should "find the solution for Vegard Hanssen 2155141" in {
    val inputRepr =
      """---6--4--
        |7----36--
        |----91-8-
        |---------
        |-5-18---3
        |---3-6-45
        |-4-2---6-
        |9-3------
        |-2----1--""".stripMargin

    val solutionRepr =
      """581672439
        |792843651
        |364591782
        |438957216
        |256184973
        |179326845
        |845219367
        |913768524
        |627435198""".stripMargin
    (Board.parse(inputRepr) >>= Solver.solve) shouldBe Board.parse(solutionRepr)
  }

  "Tilman" should "be happy when" in {
    val oneNumberBoard =
      """1--------
        |---------
        |---------
        |---------
        |---------
        |---------
        |---------
        |---------
        |---------""".stripMargin

    val board = Board.parse(oneNumberBoard).get
    println(board)
    Solver.possibleValues(0, 0, board) shouldBe Set(1)
    Solver.possibleValues(0, 1, board) shouldBe Set(2, 3, 4, 5, 6, 7, 8, 9)
    Solver.possibleValues(1, 0, board) shouldBe Set(2, 3, 4, 5, 6, 7, 8, 9)
    Solver.possibleValues(1, 1, board) shouldBe Set(2, 3, 4, 5, 6, 7, 8, 9)
  }

}
