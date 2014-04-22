/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * pow(1, 2) + pow(2, 2) + ... + pow(10, 2) = 385

 * The square of the sum of the first ten natural numbers is,
 *
 * pow((1 + 2 + ... + 10), 2) = pow(55, 2) = 3025

 * Hence the difference between the sum of the squares of the first ten natural numbers
 * and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 *
 * https://projecteuler.net/problem=6
 */
object PE006SumSquareDifference {

  def sumOfSquaresBruteForce(n: Int): Int = {
    (1 to n).map(nat => nat * nat).reduceLeft(_ + _)
  }

  def squareOfSumBruteForce(n: Int): Int = {
    val sum = (1 to n).reduceLeft(_ + _)
    sum * sum
  }

  def sumOfSquares(n: Int): Int = {
    n*(n+1)*(2*n+1)/6
  }

  def squareOfSum(n: Int) = {
    val sum = (n*(n+1))/2
    sum * sum
  }
  
  def difference(n: Int) = {
    Math.abs(sumOfSquares(n) - squareOfSum(n))
  }

}
