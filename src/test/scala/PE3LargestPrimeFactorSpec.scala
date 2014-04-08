import org.scalatest._

class PE3LargestPrimeFactorSpec extends FlatSpec with Matchers {

  "The 'primes' method" should "return the correct number of primes" in {
    PE3LargestPrimeFactor.primes(1) should be (List(2))
    PE3LargestPrimeFactor.primes(2) should be (List(2, 3))
    PE3LargestPrimeFactor.primes(3) should be (List(2, 3, 5))
    PE3LargestPrimeFactor.primes(5) should be (List(2, 3, 5, 7, 11))
    PE3LargestPrimeFactor.primes(10) should be (List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
  }

  "The 'largestPrimeFactorOf' method" should "return the correct largest primes factor of the argument" in {
    PE3LargestPrimeFactor.largestPrimeFactorOf(1) should be (1)
    PE3LargestPrimeFactor.largestPrimeFactorOf(2) should be (2)
    PE3LargestPrimeFactor.largestPrimeFactorOf(21) should be (7)
    PE3LargestPrimeFactor.largestPrimeFactorOf(35) should be (7)
    //PE3LargestPrimeFactor.largestPrimeFactorOf(600851475143l) should be (7)
  }

}
