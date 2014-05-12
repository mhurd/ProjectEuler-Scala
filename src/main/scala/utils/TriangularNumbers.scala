package utils

object TriangularNumbers {

  def triangularNumbers(): Stream[Long] = {
    triangularNumberStream(1, 1)
  }

  def triangularNumberStream(n: Long, i: Long): Stream[Long] = {
    // the next triangular number is the index in the sequence of the next number + the previous number
    Stream.cons(n, triangularNumberStream(n+i+1, i+1))
  }

}
