package utils

import scala.annotation.tailrec
import scala.util.Random

object Primes {

  lazy val seedPrimes = sieveOfEratosthenes(naturalNumberStream(2)).take(100).toList
  lazy val rand = new Random()

  // Brute force method
  def isPrime(n: Long): Boolean = {
    val maxDivisor = Math.sqrt(n).toInt
    @tailrec
    def inner(currentDivisor: Long): Boolean = {
      currentDivisor match {
        case divisor if divisor > maxDivisor => true
        case divisor if n % divisor == 0 => false
        case divisor => inner(divisor + 1)
      }
    }
    // shortcut some obvious cases
    if (n == 2 || n == 3 || n == 5 || n == 7 || n == 11) true
    else if (n == 1 || n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0 || n % 11 == 0) false
    else inner(13)
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
    (0 to BigInt(n).bitLength).map(exp => {
      if (BigInt(n).testBit(exp)) TWO.pow(exp).intValue() else 0
    }).toList.filter(_ != 0)
  }

  def raiseToPower(n: BigInt, p: Int): BigInt = {
    val powers = getPowers(p)
    @tailrec
    def inner(previousResult: BigInt, total: BigInt, currentPowerOf2: BigInt): BigInt = {
      if (currentPowerOf2 >= p) total else {
        val currentResult = previousResult.pow(2)
        val nextPowerOf2 = currentPowerOf2 * 2
        if (powers.contains(currentPowerOf2)) {
          inner(currentResult, total * currentResult, nextPowerOf2)
        } else {
          inner(currentResult, total, nextPowerOf2)
        }
      }
    }
    inner(n, ONE, TWO)
  }

  def fermatsLittleTheoremIsPrime(n: Int): Boolean = {
    n match {
      case 1 => false
      case num if List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29).contains(num) => true
      // is it dividable by one of the base primes, 2, 3, 5, 7
      case num if (n % 2 == 0) || (n % 3 == 0) || (n % 5 == 0) || (n % 7 == 0) => false
      // ok do the long check
      case num => (1 to 10).map(witnessAsNotPrime(_)).forall(!_)
    }
  }

  def witnessAsNotPrime(n: Integer): Boolean = {
    val r = Math.abs(rand.nextInt(n)) + 1
    BigInt(r).pow(n - 1) % BigInt(n) != BigInt(1) // <-- this is slow for large numbers
  }

  // Use some tricks here, pre-compute the first 100 primes and use these
  // to quickly check if a candidate number is composite otherwise proceed to
  // the lengthy check only if we're still not sure.
  def nthPrime(n: Int): Long = {
    if (n <= seedPrimes.size) {
      seedPrimes.drop(n - 1).head
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

  def primeFactorsOf(n: Long): List[Long] = {
    Primes.primes().iterator.takeWhile(_ <= Math.sqrt(n) + 10).filter(n % _ == 0).toList
  }

  def findFirstPrimeFactor(n: Long): Long = {
    if (isPrime(n)) n else {
      // ok to 'get' from the option, every (non-prime) integer has a prime factor!
      Primes.primes().iterator.find(p => p <= Math.sqrt(n) + 10 && n % p == 0).get
    }
  }

  def numberOfFactorsOf(n: Long): Long = {
    if (n == 1) 1 else { // there is 1 factor of 1
      def inner(n: Long, primeFactors: List[Long]): List[Long] = {
        val firstPrimeFactor = findFirstPrimeFactor(n)
        val rem: Long = n / firstPrimeFactor
        if (rem == 1) n :: primeFactors else inner(rem, firstPrimeFactor :: primeFactors)
      }
      val primeFactors = inner(n, List())
      // group the prime factors so we can work out the exp of each prime in the factorization.
      // We can then use the rule: 2^3 * 7^1 = 56,
      // (multiply the exponents + 1) 3+1 * 1+1 = 8 factors of 56
      primeFactors.groupBy(v => v).map(_._2.size + 1) match {
        case Nil => 1
        case x :: Nil => x
        case xs => xs.reduce(_ * _)
      }
    }
  }

}
