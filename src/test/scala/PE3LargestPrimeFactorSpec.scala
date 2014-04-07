import org.scalatest._

class PE3LargestPrimeFactorSpec extends FlatSpec with Matchers {

  "The 'primes' method" should "return the correct number of primes" in {
    PE3LargestPrimeFactor.primes(1) should be (List(2))
    PE3LargestPrimeFactor.primes(2) should be (List(2, 3))
    PE3LargestPrimeFactor.primes(3) should be (List(2, 3, 5))
    PE3LargestPrimeFactor.primes(5) should be (List(2, 3, 5, 7, 11))
    PE3LargestPrimeFactor.primes(10) should be (List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
  }

  "The 'trailDivision' method" should "return the correct primes factors of the argument" in {
    PE3LargestPrimeFactor.trialDivision(7) should be (List(7))
    PE3LargestPrimeFactor.trialDivision(21) should be (List(3, 7))
  }

}
