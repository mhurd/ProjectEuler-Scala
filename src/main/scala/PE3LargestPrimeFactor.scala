object PE3LargestPrimeFactor {

  private def naturalNumberStream(n: Long): Stream[Long] = {
    Stream.cons(n, naturalNumberStream(n+1))
  }

  // Sieve of Eratosthenes, use the stream of long values and filter successively to remove the non-primes
  private def primeStream(naturalNumbers: Stream[Long]): Stream[Long] = {
    Stream.cons(naturalNumbers.head, primeStream((naturalNumbers tail) filter (x => x % naturalNumbers.head != 0)))
  }

  def primes(n: Int): List[Long] = {
    primeStream(naturalNumberStream(2)).take(n).toList
  }

  def primes(): Stream[Long] = {
    primeStream(naturalNumberStream(2)) // start the natural numbers at 2
  }

  def largestPrimeFactorOf(n: Long): Long = {
    // handle 1's
    if (n == 1) 1
    else
    // first check that the number itself isn't prime - if it is it's it's own
    // largest prime factor (i.e. 1 * n)
    if (primes().takeWhile(p => {
      p <= n || p == n
    }).last == n) n else {
        // get a list of primes that are <= to half def main(args: Array[String]){
        // because it can't be any larger than half without being the number itself
        primes().takeWhile(_ <= n/2).filter(n % _ == 0).last
      }
  }

  def fastLargestPrimeFactorOf(n: Long): Long = {
    var theNum = n
    naturalNumberStream(2).dropWhile(nat => {
        while (theNum % nat == 0) {
          theNum /= nat
        }
        theNum > 1
    }).head

  }

}
