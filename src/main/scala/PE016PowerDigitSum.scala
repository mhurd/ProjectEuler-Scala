import utils.Timer

/**
 * 2 pow 15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

 * What is the sum of the digits of the number 2 pow 1000?
 *
 * https://projecteuler.net/problem=16
 */
object PE016PowerDigitSum extends Timer {

  def solve(exp: Int): BigInt = {
    (BigInt(2) << (exp - 1)).toString().map(_.toString.toInt).reduce(_+_)
  }

  def solveForProblem(): BigInt = {
    solve(1000)
  }

}
