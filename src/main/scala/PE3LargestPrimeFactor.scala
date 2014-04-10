object PE3LargestPrimeFactor {

  def primes(n: Int): List[Long] = {
    primeStream(naturalNumberStream(2)).take(n).toList
  }

  def primes(): Stream[Long] = {
    primeStream(naturalNumberStream(2)) // start the natural numbers at 2
  }

  def fastPrimeFactorsOf(n: Long): List[Long] = {
    naturalNumberStream(2).iterator.takeWhile(_ <= Math.sqrt(n) + 10).filter(factor => (n % factor == 0) && Range.Long(2, factor, 1).forall(factor % _ != 0)).toList
  }

  def fastLargestPrimeFactorOf(n: Long): Long = {
    fastPrimeFactorsOf(n).last
  }

  def primeFactorsOf(n: Long): List[Long] = {
    primes().iterator.takeWhile(_ <= Math.sqrt(n) + 10).filter(n % _ == 0).toList
  }

  // This one doesn't work for large numbers - something up with the
  // prime stream, a problem for another day
  def largestPrimeFactorOf(n: Long): Long = {
    primeFactorsOf(n).last
  }

  private def naturalNumberStream(n: Long): Stream[Long] = {
    Stream.cons(n, naturalNumberStream(n + 1))
  }

  // Sieve of Eratosthenes, use the stream of long values and filter successively to remove the non-primes
  private def primeStream(naturalNumbers: Stream[Long]): Stream[Long] = {
    Stream.cons(naturalNumbers.head, primeStream((naturalNumbers tail) filter (x => x % naturalNumbers.head != 0)))
  }

}
