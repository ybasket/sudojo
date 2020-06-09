package sudojo

import cats.implicits._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SolverTest extends AnyFlatSpec with Matchers {

  // Note this board isn't valid as of the rules
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

  "The Solver" should "find the solution for Vegard Hanssen 2155141" in {
    (Board.parse(inputRepr) >>= Solver.solve) shouldBe Board.parse(solutionRepr)
  }

}
