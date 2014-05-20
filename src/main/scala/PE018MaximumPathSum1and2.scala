import scala.annotation.tailrec
import scala.io.Source
import utils.Timer

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 *                             75
 *                           95 64
 *                         17 47 82
 *                       18 35 87 10
 *                     20 04 82 47 65
 *                   19 01 23 75 03 34
 *                 88 02 77 73 07 63 67
 *               99 65 04 28 06 16 70 92
 *             41 41 26 56 83 40 80 70 33
 *           41 48 72 33 47 32 37 16 94 29
 *         53 71 44 65 25 43 91 52 97 51 14
 *       70 11 33 28 77 73 17 78 39 68 17 57
 *     91 71 52 38 17 14 91 43 58 50 27 29 48
 *   63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows;
 * it cannot be solved by brute force, and requires a clever method! ;o)
 *
 * https://projecteuler.net/problem=18
 * &
 * https://projecteuler.net/problem=19 (uses main/resources/PE67-triangle.txt)
 *
 */
object PE018MaximumPathSum1and2 extends Timer {

  val problemTriangle = Array(
      Array(75),
      Array(95,64) ,
      Array(17,47,82),
      Array(18,35,87,10),
      Array(20,4,82,47,65),
      Array(19,1,23,75,3,34),
      Array(88,2,77,73,7,63,67),
      Array(99,65,4,28,6,16,70,92),
      Array(41,41,26,56,83,40,80,70,33),
      Array(41,48,72,33,47,32,37,16,94,29) ,
      Array(53,71,44,65,25,43,91,52,97,51,14),
      Array(70,11,33,28,77,73,17,78,39,68,17,57),
      Array(91,71,52,38,17,14,91,43,58,50,27,29,48),
      Array(63,66,04,68,89,53,67,30,73,16,69,87,40,31),
      Array(04,62,98,27,23,9,70,98,73,93,38,53,60,04,23)
  )

  def solveForProblem67(): Int = {
    val source = Source.fromURL(getClass.getResource("PE067-triangle.txt"))
    val foo = source.getLines().map(line => line.split(" ").map(_.toInt))
    solve(foo.toArray)
  }

  def solveForProblem18(): Int = {
    solve(problemTriangle)
  }

  def solve(triangle: Array[Array[Int]]): Int = {

    val reverseTriangle = triangle.reverse

    @tailrec
    def inner(index: Int, tally: Array[Int]): Array[Int] = {
      if (index == reverseTriangle.length) tally else {
        val newTally = reverseTriangle(index).zipWithIndex.map(t => {
          t._1 + Math.max(tally(t._2), tally(t._2 + 1))
        })
        inner(index+1, newTally)
      }
    }
    // start at the second row from the bottom
    // work upwards adding the max from the previous row's pair of
    // options to the current value on the row - effectively totaling up the
    // maximum route to the single top node where the remaining value is the max route.
    inner(1, reverseTriangle.head).max
  }

}
