import utils.Primes

object PE3LargestPrimeFactor {

  def fastPrimeFactorsOf(n: Long): List[Long] = {
    Primes.naturalNumberStream(2).iterator.takeWhile(_ <= Math.sqrt(n) + 10).filter(factor => (n % factor == 0) && Range.Long(2, factor, 1).forall(factor % _ != 0)).toList
  }

  def fastLargestPrimeFactorOf(n: Long): Long = {
    fastPrimeFactorsOf(n).last
  }

  def primeFactorsOf(n: Long): List[Long] = {
    Primes.primes().iterator.takeWhile(_ <= Math.sqrt(n) + 10).filter(n % _ == 0).toList
  }

  // This one doesn't work for large numbers - something up with the
  // prime stream, a problem for another day
  def largestPrimeFactorOf(n: Long): Long = {
    primeFactorsOf(n).last
  }

}
