import utils.{MathsUtil, Month, Day, Timer}
import utils.Month._
import utils.Day._

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 * https://projecteuler.net/problem=20
 *
 */
object PE020FactorialDigitSum extends Timer {

  def solveForProblem(): BigInt = {
    MathsUtil.factorial(100).toString().map(_.toString.toInt).reduceLeft(_+_)
  }

}
