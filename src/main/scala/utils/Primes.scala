package utils

import scala.annotation.tailrec
import scala.util.Random
import scala.math


object Primes {

  lazy val seedPrimes = sieveOfEratosthenes(naturalNumberStream(2)).take(100).toList
  lazy val rand = new Random()

  def isPrime(n: Long): Boolean = {
    if (n < 2) false
    if (n == 2 || n == 3) true
    if (n % 2 == 0 || n % 3 == 0) false
    val maxDivisor = Math.sqrt(n)
    var divisor = 5
    while (divisor <= maxDivisor) {
      if (n % divisor == 0 || n % (divisor + 2) == 0) false
      divisor = divisor + 6
    }
    true
  }

  def fermatsLittleTheoremIsPrime(n: Long): Boolean = {
    // shortcut the smaller primes
    if (n == 1) false else if (List(2,3,5,7,11,13,17,19,23,29).contains(n)) true else {
      (1 to 10).map(f = _ => {
        val l: Long = Math.abs(rand.nextLong())
        val r: Long = if (l == 0) 1 else (n * (l.toDouble / Long.MaxValue)).toLong
        // wow, handy modPow function on BigInt!
        val isWitness = BigInt(r).modPow(BigInt(n-1), BigInt(n)) != BigInt(1)
        isWitness
      }).forall(_ == false)
    }
  }

  // Use some tricks here, pre-compute the first 100 primes an use these
  // to quickly check if a candidate number is composite otherwise proceed to
  // the lengthy check only if we're still not sure.
  def nthPrime(n: Int): Long = {
    if (n <= seedPrimes.size) {
      seedPrimes.drop(n-1).head
    } else {
      @tailrec
      def search(primes: List[Long], candidate: Long): Long = {
        if (primes.size == n) primes.head
        else {
          if (seedPrimes.exists(candidate % _ == 0)) {
            // candidate is not prime, it's a composite
            search(primes, candidate + 1)
          } else {
            // do the real check
            if (seedPrimes.contains(candidate) || isPrime(candidate)) {
              search(candidate :: primes, candidate + 1)
            } else {
              search(primes, candidate + 1)
            }
          }
        }
      }
      search(seedPrimes, 2)
    }
  }

  def primes(): Stream[Long] = {
    sieveOfEratosthenes(naturalNumberStream(2)) // start the natural numbers at 2
  }

  def naturalNumberStream(n: Long): Stream[Long] = {
    Stream.cons(n, naturalNumberStream(n + 1))
  }

  // Sieve of Eratosthenes, use the stream of long values and filter successively to remove the non-primes
  def sieveOfEratosthenes(naturalNumbers: Stream[Long]): Stream[Long] = {
    Stream.cons(naturalNumbers.head, sieveOfEratosthenes((naturalNumbers tail) filter (x => x % naturalNumbers.head != 0)))
  }

}
