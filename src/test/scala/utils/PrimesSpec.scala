package utils

import org.scalatest._

class PrimesSpec extends FlatSpec with Matchers {

  "The 'primes' method" should "return the correct number of primes" in {
    Primes.primes().take(1) should be(List(2))
    Primes.primes().take(2) should be(List(2, 3))
    Primes.primes().take(3) should be(List(2, 3, 5))
    Primes.primes().take(5) should be(List(2, 3, 5, 7, 11))
    Primes.primes().take(10) should be(List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
  }

  "The 'nthPrime' method" should "return the correct prime" in {
    Primes.nthPrime(1) should be(2)
    Primes.nthPrime(2) should be(3)
    Primes.nthPrime(3) should be(5)
    Primes.nthPrime(5) should be(11)
    Primes.nthPrime(10) should be(29)
  }

}
