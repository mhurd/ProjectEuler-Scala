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

  "The 'fermatsLittleTheorem' method" should "return detect primes correctly" in {
    (Primes.fermatsLittleTheoremIsPrime(1)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(2)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(3)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(4)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(5)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(6)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(7)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(8)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(9)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(10)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(11)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(12)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(13)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(14)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(15)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(16)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(17)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(18)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(19)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(20)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(21)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(22)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(23)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(29)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(30)) should be(false)
    // larger primes
    (Primes.fermatsLittleTheoremIsPrime(1301081)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(179426081)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(2038076783)) should be(true)
    (Primes.fermatsLittleTheoremIsPrime(1301089)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(179426090)) should be(false)
    (Primes.fermatsLittleTheoremIsPrime(2038076795)) should be(false)
  }

}
