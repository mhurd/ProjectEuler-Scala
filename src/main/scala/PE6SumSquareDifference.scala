object PE6SumSquareDifference {

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
