import utils.Primes

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * https://projecteuler.net/problem=10
 */
object PE010SummationOfPrimes {

  def sumPrimesBelow(n: Long): Long = {
    Primes.primeIterator().takeWhile(_ < n).sum
  }

}
