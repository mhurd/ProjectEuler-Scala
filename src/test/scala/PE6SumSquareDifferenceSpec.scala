import org.scalatest._

class PE6SumSquareDifferenceSpec extends FlatSpec with Matchers {

  "The 'sumOfSquaresBruteForce' method" should "return the correct value" in {
    PE6SumSquareDifference.sumOfSquaresBruteForce(10) should be(385)
    PE6SumSquareDifference.sumOfSquaresBruteForce(3) should be(14)
    PE6SumSquareDifference.sumOfSquaresBruteForce(5) should be(55)
    PE6SumSquareDifference.sumOfSquaresBruteForce(100) should be(338350)
  }

  "The 'squareOfSumBruteForce' method" should "return the correct value" in {
    PE6SumSquareDifference.squareOfSumBruteForce(10) should be(3025)
    PE6SumSquareDifference.squareOfSumBruteForce(3) should be(36)
    PE6SumSquareDifference.squareOfSumBruteForce(5) should be(225)
    PE6SumSquareDifference.squareOfSumBruteForce(100) should be(25502500)
  }

  "The 'sumOfSquares' method" should "return the correct value" in {
    PE6SumSquareDifference.sumOfSquares(10) should be(385)
    PE6SumSquareDifference.sumOfSquares(3) should be(14)
    PE6SumSquareDifference.sumOfSquares(5) should be(55)
    PE6SumSquareDifference.sumOfSquares(100) should be(338350)
  }

  "The 'squareOfSum' method" should "return the correct value" in {
    PE6SumSquareDifference.squareOfSum(10) should be(3025)
    PE6SumSquareDifference.squareOfSum(3) should be(36)
    PE6SumSquareDifference.squareOfSum(5) should be(225)
    PE6SumSquareDifference.squareOfSum(100) should be(25502500)
  }

  "The 'difference' method" should "return the correct value" in {
    PE6SumSquareDifference.difference(10) should be(2640)
    PE6SumSquareDifference.difference(3) should be(22)
    PE6SumSquareDifference.difference(5) should be(170)
    PE6SumSquareDifference.difference(100) should be(25164150)
  }

}
