object PE2EvenFibonacciNumbers {

  // stream of fib numbers but starts with 0 1 1 (the seeds to the scan)
  // we will remove these when taking the fibs from the stream
  val fibs: Stream[Int] = 0 #:: fibs.scanLeft(1)(_ + _)

  def fib(n: Int): Int =
    if (n <= 0) 0 else fibs.take(n + 2).drop(2).last

  def sumOfEvenFibonacciNumbersBelow(below: Int) =
    fibs.takeWhile(_ < below).filter(_ % 2 == 0).reduceLeft(_ + _)

}
