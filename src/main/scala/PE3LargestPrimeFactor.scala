object PE3LargestPrimeFactor {

  private def intStream(n: Int): Stream[Int] = {
    Stream.cons(n, intStream(n+1))
  }

  private def primeStream(ints: Stream[Int]): Stream[Int] = {
    Stream.cons(ints.head, primeStream((ints tail) filter (x => x % ints.head != 0)))
  }

  def primes(n: Int): List[Int] = {
    primeStream(intStream(2)).take(n).toList
  }

  def trialDivision(n: Int): List[Int] = {
    def foo(n: Int, p: Int, primeFactors: List[Int]): (Int, List[Int]) = {
      if (p*p > n) {
        (n, primeFactors)
      } else if (n % p == 0) {
        foo(n/p, p, p :: primeFactors)
      } else {
        foo(n/p, p, primeFactors)
      }
    }
    if (n == 1) List(1) else {
      val bar = primes((n*0.5 + 1).toInt).map(p => foo(n, p, List()))
      print(bar)
      if (bar.unzip._1.last > 1) {
        bar.unzip._1.last :: bar.unzip._2.flatten
      } else {
        bar.unzip._2.flatten
      }
    }
  }

}
