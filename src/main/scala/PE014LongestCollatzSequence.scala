import scala.annotation.tailrec
import utils.Timer

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * https://projecteuler.net/problem=14
 */
object PE014LongestCollatzSequence extends Timer {

  def nextCollatzNumber(n: Long): Long = {
    if (n % 2 == 0) n/2 else (3*n) + 1
  }

  def findCollatzSequenceLength(n: Long): Int = {
    @tailrec
    def inner(current: Long, count: Int): Int = {
        if (current == 1) count else inner(nextCollatzNumber(current), count+1)
    }
    inner(n, 1)
  }

  def solve(maxN: Long, memo: Boolean) : Long = {
    Range.Long(1, maxN, 1).map(n => {
      (n, findCollatzSequenceLength(n))
    }).maxBy(t => t._2)._1
  }

  def solveForProblem(): Long = {
    println("time taken = " + timeInSeconds(() => solve(1000000, memo = false), 2) + " seconds")
    solve(1000000, memo = true)
  }

}
