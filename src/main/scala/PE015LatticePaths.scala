import utils.Timer
import utils.PascalsTriangle

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 * https://projecteuler.net/problem=15
 */
object PE015LatticePaths extends Timer {

  def solve(width: Int): BigInt = {
    // the number of paths through the lattice can be found at 2*width of the grid.
    // the element to use is the middle one, i.e. width
    PascalsTriangle.getValue(2*width, width)
  }

  def solveForProblem(): BigInt = {
    solve(20)
  }

}
