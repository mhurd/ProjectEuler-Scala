import org.scalatest._

class PE010SummationOfPrimesSpec extends FlatSpec with Matchers {

  "The 'sumPrimesBelow' method" should "return the correct value" in {
    //PE010SummationOfPrimes.sumPrimesBelow(10) should be(17)
    //PE010SummationOfPrimes.sumPrimesBelow(30) should be(129)
    PE010SummationOfPrimes.sumPrimesBelow(2000000) should be(142913828922l)
  }

}
