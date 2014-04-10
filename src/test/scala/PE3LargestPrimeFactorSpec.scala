import org.scalatest._

class PE3LargestPrimeFactorSpec extends FlatSpec with Matchers {

  "The 'primes' method" should "return the correct number of primes" in {
    PE3LargestPrimeFactor.primes(1) should be(List(2))
    PE3LargestPrimeFactor.primes(2) should be(List(2, 3))
    PE3LargestPrimeFactor.primes(3) should be(List(2, 3, 5))
    PE3LargestPrimeFactor.primes(5) should be(List(2, 3, 5, 7, 11))
    PE3LargestPrimeFactor.primes(10) should be(List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
  }

  // Sieve method - find primes and then find the largest that is a factor
  // doesn't work though, uses too much heap

  "The 'primeFactorsOf' method" should "return the correct primes factors" in {
    PE3LargestPrimeFactor.primeFactorsOf(2) should be(List(2))
    PE3LargestPrimeFactor.primeFactorsOf(4) should be(List(2))
    PE3LargestPrimeFactor.primeFactorsOf(5) should be(List(5))
    PE3LargestPrimeFactor.primeFactorsOf(7) should be(List(7))
    PE3LargestPrimeFactor.primeFactorsOf(21) should be(List(3, 7))
    PE3LargestPrimeFactor.primeFactorsOf(35) should be(List(5, 7))
    PE3LargestPrimeFactor.primeFactorsOf(13195) should be(List(5, 7, 13, 29))
    // doesn't work, java.lang.OutOfMemoryError: Java heap space (at 1024M)
    // PE3LargestPrimeFactor.primeFactorsOf(600851475143l) should be(List(71, 839, 1471, 6857))
  }

  "The 'largestPrimeFactorOf' method" should "return the correct largest primes factor of the argument" in {
    // Sieve of Eratosthenes is too slow for the large numbers - at least this implementation is
    PE3LargestPrimeFactor.largestPrimeFactorOf(2) should be(2)
    PE3LargestPrimeFactor.largestPrimeFactorOf(21) should be(7)
    PE3LargestPrimeFactor.largestPrimeFactorOf(35) should be(7)
    // doesn't work, java.lang.OutOfMemoryError: Java heap space (at 1024M)
    // PE3LargestPrimeFactor.largestPrimeFactorOf(600851475143l) should be(6857)
  }

  // Brute force method - find factors and then filter out the primes

  "The 'fastPrimeFactorsOf' method" should "return the correct primes factors" in {
    PE3LargestPrimeFactor.fastPrimeFactorsOf(2) should be(List(2))
    PE3LargestPrimeFactor.fastPrimeFactorsOf(4) should be(List(2))
    PE3LargestPrimeFactor.fastPrimeFactorsOf(5) should be(List(5))
    PE3LargestPrimeFactor.fastPrimeFactorsOf(7) should be(List(7))
    PE3LargestPrimeFactor.fastPrimeFactorsOf(21) should be(List(3, 7))
    PE3LargestPrimeFactor.fastPrimeFactorsOf(35) should be(List(5, 7))
    PE3LargestPrimeFactor.fastPrimeFactorsOf(13195) should be(List(5, 7, 13, 29))
    PE3LargestPrimeFactor.fastPrimeFactorsOf(600851475143l) should be(List(71, 839, 1471, 6857))
  }

  "The 'fastLargestPrimeFactorOf' method" should "return the correct largest primes factor of the argument" in {
    PE3LargestPrimeFactor.fastLargestPrimeFactorOf(2) should be(2)
    PE3LargestPrimeFactor.fastLargestPrimeFactorOf(21) should be(7)
    PE3LargestPrimeFactor.fastLargestPrimeFactorOf(35) should be(7)
    PE3LargestPrimeFactor.fastLargestPrimeFactorOf(600851475143l) should be(6857)
  }

}
