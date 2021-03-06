import scala.collection.mutable

/**
 *  Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 *  By starting with 1 and 2, the first 10 terms will be:
 *
 *  1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 *  By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 *  find the sum of the even-valued terms.
 *
 *  https://projecteuler.net/problem=2
 */
object PE002EvenFibonacciNumbers {

  // usual stream of fib numbers starts with 0 1 1 2 3 5 8 ...
  // however this problem assumes that it starts 1 2 3 5 8 13 ...
  val fibs: Stream[BigInt] = BigInt(1) #:: fibs.scanLeft(BigInt(2))(_ + _)

  def fib(n: Int): BigInt = {
    val memo = (n: Int) => {
      val cache = mutable.Map[BigInt, BigInt]()
      cache.getOrElseUpdate(n, if (n <= 0) 0 else fibs.take(n).last)
    }
    memo(n)
  }

  def sumOfEvenFibonacciNumbersBelow(below: Int) =
    fibs.takeWhile(_ < below).filter(_ % 2 == 0).reduceLeft(_ + _)

}
