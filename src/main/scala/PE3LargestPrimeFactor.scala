object PE3LargestPrimeFactor {

  private def longStream(n: Long): Stream[Long] = {
    Stream.cons(n, longStream(n+1))
  }

  private def primeStream(ints: Stream[Long]): Stream[Long] = {
    Stream.cons(ints.head, primeStream((ints tail) filter (x => x % ints.head != 0)))
  }

  def primes(n: Int): List[Long] = {
    primeStream(longStream(2)).take(n).toList
  }

  def primes(): Stream[Long] = {
    primeStream(longStream(2))
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

}