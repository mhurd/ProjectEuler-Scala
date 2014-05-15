package utils

import MathsUtil._

object PascalsTriangle {

  /**
   * Gets the nth element from the row in the triangle.
   * 0-indexed for both values.
   */
  def getValue(row: Int, n: Int): BigInt = {
    assert (row >= 0 && n >= 0, { throw new ArithmeticException("Pascal's Triangle doesn't support negative indices") })
    assert (n <= row, { throw new ArithmeticException("Row " + row + " doesn't have an value at index " + n + " (max index would be " + row + ")") })
    if (row == 0 || n == 0 || (row == n)) 1 else factorial(row) / (factorial(n) * factorial(row - n))
  }

}
