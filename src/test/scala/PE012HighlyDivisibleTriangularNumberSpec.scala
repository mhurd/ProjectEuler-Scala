import org.scalatest._

class PE012HighlyDivisibleTriangularNumberSpec extends FlatSpec with Matchers {

  "The 'firstWithMoreDivisors' method" should "return the correct triangular number" in {
    PE012HighlyDivisibleTriangularNumber.firstWithMoreDivisors(5) should be(28)
    PE012HighlyDivisibleTriangularNumber.firstWithMoreDivisors(7) should be(36)
    PE012HighlyDivisibleTriangularNumber.firstWithMoreDivisors(500) should be(76576500)
  }

}
