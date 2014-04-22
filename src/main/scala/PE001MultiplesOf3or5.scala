/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * https://projecteuler.net/problem=1
 */
object PE001MultiplesOf3or5 {

  def sumOfMultiplesOf3or5Below(below: Int): Int = {
    findSum(below, 3, 5)
  }

  private def findSum(below: Int, multiples: Int*) = {
    if (below <= 0) 0
    else {
      (for {
        below <- 0.to(below - 1)
        if multiples.exists(below % _ == 0)
      } yield {
        below
      }).reduceLeft(_ + _)
    }
  }

}
