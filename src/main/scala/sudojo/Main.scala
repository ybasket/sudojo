package sudojo

object Main extends App {

  args.toList match {
    case input :: _ =>
      val solution = for {
        board <- Board.parse(input)
        solution <- Solver.solve(board)
      } yield solution
      println(solution)
    case Nil => println("Please provide a board")
  }

}
