import org.scalatest._

class PE003LargestPrimeFactorSpec extends FlatSpec with Matchers {

  // Sieve method - find primes and then find the largest that is a factor
  // doesn't work though, uses too much heap

  "The 'primeFactorsOf' method" should "return the correct primes factors" in {
    PE003LargestPrimeFactor.primeFactorsOf(2) should be(List(2))
    PE003LargestPrimeFactor.primeFactorsOf(4) should be(List(2))
    PE003LargestPrimeFactor.primeFactorsOf(5) should be(List(5))
    PE003LargestPrimeFactor.primeFactorsOf(7) should be(List(7))
    PE003LargestPrimeFactor.primeFactorsOf(21) should be(List(3, 7))
    PE003LargestPrimeFactor.primeFactorsOf(35) should be(List(5, 7))
    PE003LargestPrimeFactor.primeFactorsOf(13195) should be(List(5, 7, 13, 29))
    // doesn't work, java.lang.OutOfMemoryError: Java heap space (at 1024M)
    // PE3LargestPrimeFactor.primeFactorsOf(600851475143l) should be(List(71, 839, 1471, 6857))
  }

  "The 'largestPrimeFactorOf' method" should "return the correct largest primes factor of the argument" in {
    // Sieve of Eratosthenes is too slow for the large numbers - at least this implementation is
    PE003LargestPrimeFactor.largestPrimeFactorOf(2) should be(2)
    PE003LargestPrimeFactor.largestPrimeFactorOf(21) should be(7)
    PE003LargestPrimeFactor.largestPrimeFactorOf(35) should be(7)
    // doesn't work, java.lang.OutOfMemoryError: Java heap space (at 1024M)
    // PE3LargestPrimeFactor.largestPrimeFactorOf(600851475143l) should be(6857)
  }

  // Brute force method - find factors and then filter out the primes

  "The 'fastPrimeFactorsOf' method" should "return the correct primes factors" in {
    PE003LargestPrimeFactor.fastPrimeFactorsOf(2) should be(List(2))
    PE003LargestPrimeFactor.fastPrimeFactorsOf(4) should be(List(2))
    PE003LargestPrimeFactor.fastPrimeFactorsOf(5) should be(List(5))
    PE003LargestPrimeFactor.fastPrimeFactorsOf(7) should be(List(7))
    PE003LargestPrimeFactor.fastPrimeFactorsOf(21) should be(List(3, 7))
    PE003LargestPrimeFactor.fastPrimeFactorsOf(35) should be(List(5, 7))
    PE003LargestPrimeFactor.fastPrimeFactorsOf(13195) should be(List(5, 7, 13, 29))
    PE003LargestPrimeFactor.fastPrimeFactorsOf(600851475143l) should be(List(71, 839, 1471, 6857))
  }

  "The 'fastLargestPrimeFactorOf' method" should "return the correct largest primes factor of the argument" in {
    PE003LargestPrimeFactor.fastLargestPrimeFactorOf(2) should be(2)
    PE003LargestPrimeFactor.fastLargestPrimeFactorOf(21) should be(7)
    PE003LargestPrimeFactor.fastLargestPrimeFactorOf(35) should be(7)
    PE003LargestPrimeFactor.fastLargestPrimeFactorOf(600851475143l) should be(6857)
  }

}
