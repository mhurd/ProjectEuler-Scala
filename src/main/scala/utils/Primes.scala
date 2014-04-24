package utils

import scala.annotation.tailrec
import scala.util.Random

object Primes {

  lazy val seedPrimes = sieveOfEratosthenes(naturalNumberStream(2)).take(100).toList
  lazy val rand = new Random()

  def isPrime(n: Long): Boolean = {
    if (n == 1 || n == 2 || n == 3 || n == 5 || n == 7 || n == 11) true else {
      if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0 || n % 11 == 0) false
      else {
        val maxDivisor = Math.sqrt(n).toInt
        var divisor = 13
        var isPrime = true
        while (divisor <= maxDivisor && isPrime) {
          if (n % divisor == 0) {
            isPrime = false
          } else {
            divisor = divisor + 1
          }
        }
        isPrime
      }
    }
  }

  def primeIterator() = new Iterator[Long] {

    private var currentPrime: Long = 1

    override def next(): Long = {
      currentPrime = currentPrime + 1
      while (!isPrime(currentPrime)) {
        currentPrime = currentPrime + 1
      }
      currentPrime
    }

    override def hasNext: Boolean = true

  }

  val ZERO = BigInt(0)
  val ONE = BigInt(1)
  val TWO = BigInt(2)

  def getPowers(n: Int): List[Int] = {
    (0 to BigInt(n).bitLength).map(i => {
      if (BigInt(n).testBit(i)) TWO.pow(i).intValue() else 0
    }).toList.filter(_ != 0)
  }

  def raiseToPower(n: BigInt, p: Int): BigInt = {
    val powers = getPowers(p)
    var result = ONE
    var prevResult = n
    var i = 1
    var powerOf2 = TWO.pow(i)
    while (powerOf2 < p) {
      val r = prevResult.pow(2)
      prevResult = r
      if (powers.contains(powerOf2)) {
        result = result * r
      }
      i = i+1
      powerOf2 = TWO.pow(i)
    }
    result
  }

  def fermatsLittleTheoremIsPrime(n: Int): Boolean = {
    // shortcut the smaller primes
    if (n == 1) false
    else if (List(2,3,5,7,11,13,17,19,23,29).contains(n)) true
    else if ((n % 2 == 0) || (n % 3 == 0) || (n % 5 == 0) || (n % 7 == 0)) {
      false // its dividable by one of the base primes, 2, 3, 5, 7
    } else {
      // ok do the long check
      (1 to 10).map(f = _ => {
        witnessAsNotPrime(n)
      }).forall(_ == false)
    }
  }

  def witnessAsNotPrime(n: Integer): Boolean = {
    val l = Math.abs(rand.nextInt(n))+1
    BigInt(l).pow(n-1) % BigInt(n) != BigInt(1) // <-- this is slow for large numbers
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