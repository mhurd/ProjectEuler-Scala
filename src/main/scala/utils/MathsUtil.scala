package utils

object MathsUtil {

  def factorial(n: Long): BigInt = {
    def inner(n: Long, result: BigInt): BigInt = {
      n match {
        case 0 => result
        case 1 => result
        case x => inner(n - 1, result * n)
      }
    }
    inner(n, 1)
  }

}
