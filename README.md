# Coding Dojo: *Sudojo* – A Sudoku solver
Practice your Scala skills by implementing a Sudoku solving program in Scala. Developed for an internal session @Mobimeo.

## Run
Simple `sbt run`, provide a board representation as one argument to get a solution. `sbt test` for development. Rest is on you.

## Steps
I recommend tackling the implementation in the following order:
1. Define your `Board` representation by choosing an appropriate data structure for `Board.fields`.
2. Implement `Board.parse` and `Board.show`. Verify your implementation using `BoardTest`.
3. Think of how to implement rule checking on your `Board` and implement what you need for sure.
4. Implement Solver.solve and verify using `SolverTest`.
5. BONUS: Calculate all solutions for ambiguous boards in `Solver.solutions`.
6. BONUS: Make board printing prettier by enhancing `Board.show`.
7. BONUS: Find yourself another challenge, Sudoku gets boring over time.


## License
Licensed as [Beerware](https://spdx.org/licenses/Beerware.html)