import org.scalatest._

class PE7The10001stPrimeSpec extends FlatSpec with Matchers {

  "The 'primes' method" should "return the correct value" in {
    PE7The10001stPrime.prime(1) should be(2)
    PE7The10001stPrime.prime(2) should be(3)
    PE7The10001stPrime.prime(3) should be(5)
    PE7The10001stPrime.prime(4) should be(7)
    PE7The10001stPrime.prime(5) should be(11)
    PE7The10001stPrime.prime(6) should be(13)
    PE7The10001stPrime.prime(10001) should be(104743)
  }

}
