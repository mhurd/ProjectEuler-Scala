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
    Primes.fermatsLittleTheoremIsPrime(1) should be(false)
    Primes.fermatsLittleTheoremIsPrime(2) should be(true)
    Primes.fermatsLittleTheoremIsPrime(3) should be(true)
    Primes.fermatsLittleTheoremIsPrime(4) should be(false)
    Primes.fermatsLittleTheoremIsPrime(5) should be(true)
    Primes.fermatsLittleTheoremIsPrime(6) should be(false)
    Primes.fermatsLittleTheoremIsPrime(7) should be(true)
    Primes.fermatsLittleTheoremIsPrime(8) should be(false)
    Primes.fermatsLittleTheoremIsPrime(9) should be(false)
    Primes.fermatsLittleTheoremIsPrime(10) should be(false)
    Primes.fermatsLittleTheoremIsPrime(11) should be(true)
    Primes.fermatsLittleTheoremIsPrime(12) should be(false)
    Primes.fermatsLittleTheoremIsPrime(13) should be(true)
    Primes.fermatsLittleTheoremIsPrime(14) should be(false)
    Primes.fermatsLittleTheoremIsPrime(15) should be(false)
    Primes.fermatsLittleTheoremIsPrime(16) should be(false)
    Primes.fermatsLittleTheoremIsPrime(17) should be(true)
    Primes.fermatsLittleTheoremIsPrime(18) should be(false)
    Primes.fermatsLittleTheoremIsPrime(19) should be(true)
    Primes.fermatsLittleTheoremIsPrime(20) should be(false)
    Primes.fermatsLittleTheoremIsPrime(21) should be(false)
    Primes.fermatsLittleTheoremIsPrime(22) should be(false)
    Primes.fermatsLittleTheoremIsPrime(23) should be(true)
    Primes.fermatsLittleTheoremIsPrime(29) should be(true)
    Primes.fermatsLittleTheoremIsPrime(30) should be(false)
  }

  "The 'isPrime' method" should "return detect primes correctly" in {
    Primes.isPrime(1) should be(false)
    Primes.isPrime(2) should be(true)
    Primes.isPrime(3) should be(true)
    Primes.isPrime(4) should be(false)
    Primes.isPrime(5) should be(true)
    Primes.isPrime(6) should be(false)
    Primes.isPrime(7) should be(true)
    Primes.isPrime(8) should be(false)
    Primes.isPrime(9) should be(false)
    Primes.isPrime(10) should be(false)
    Primes.isPrime(11) should be(true)
    Primes.isPrime(12) should be(false)
    Primes.isPrime(13) should be(true)
    Primes.isPrime(14) should be(false)
    Primes.isPrime(15) should be(false)
    Primes.isPrime(16) should be(false)
    Primes.isPrime(17) should be(true)
    Primes.isPrime(18) should be(false)
    Primes.isPrime(19) should be(true)
    Primes.isPrime(20) should be(false)
    Primes.isPrime(21) should be(false)
    Primes.isPrime(22) should be(false)
    Primes.isPrime(23) should be(true)
    Primes.isPrime(29) should be(true)
    Primes.isPrime(30) should be(false)
    Primes.isPrime(3040) should be(false)
    Primes.isPrime(3041) should be(true)
    Primes.isPrime(6689) should be(true)
    Primes.isPrime(6690) should be(false)
    Primes.isPrime(6691) should be(true)
  }

  "The 'getPowers'" should "function correctly" in {
    Primes.getPowers(6) should be (List(2,4))
    Primes.getPowers(7) should be (List(1,2,4))
    Primes.getPowers(8) should be (List(8))
  }

  private def timeInSeconds(f: () => Unit, repetitions: Int): Double = {
    val start1: Double = System.currentTimeMillis()
    (1 to repetitions).foreach(_ => f())
    val stop1: Double = System.currentTimeMillis()
    (stop1 - start1) / 1000
  }

  "The 'raiseToPower'" should "function correctly compared to .pow for large exponents" in {
    val num = 7
    val bigExp = 500000
    val repetitions = 2
    Primes.raiseToPower(num, bigExp) should be (BigInt(num).pow(bigExp))
    // check that it takes a comparable time (+/- 10%), can't seem to get it much faster which makes sense.
    // its slower for smaller exponents.
    val raiseToPowerTime = timeInSeconds(() => Primes.raiseToPower(num, bigExp), repetitions)
    println("raiseToPower time = " + raiseToPowerTime + " seconds")
    val powTime = timeInSeconds(() =>  BigInt(num).pow(bigExp), repetitions)
    println("pow time = " + powTime  + " seconds");
    val ratio = raiseToPowerTime/powTime
    println("For " + num + " ^ " + bigExp + ", raiseToPower's time taken ratio vs. pow is " + ratio)
    ratio <= 1.10 should be (true)
  }

  "The 'primeIterator'" should "function correctly" in {
    val itr = Primes.primeIterator()
    itr.next() should be(2)
    itr.next() should be(3)
    itr.next() should be(5)
    itr.next() should be(7)
    itr.next() should be(11)
  }

  "The 'numberOfFactorsOf' method" should "return all the factors of the supplied number" in {
    Primes.numberOfFactorsOf(1) should be(1)
    Primes.numberOfFactorsOf(3) should be(2)
    Primes.numberOfFactorsOf(6) should be(4)
    Primes.numberOfFactorsOf(10) should be(4)
    Primes.numberOfFactorsOf(15) should be(4)
    Primes.numberOfFactorsOf(21) should be(4)
    Primes.numberOfFactorsOf(28) should be(6)
    Primes.numberOfFactorsOf(30) should be(8)
    Primes.numberOfFactorsOf(72) should be(12)
    Primes.numberOfFactorsOf(156) should be(12)
    Primes.numberOfFactorsOf(15668) should be(6)
    Primes.numberOfFactorsOf(1566877) should be(8)
  }

}
