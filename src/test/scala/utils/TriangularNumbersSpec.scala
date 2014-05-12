package utils

import org.scalatest._

class TriangularNumbersSpec extends FlatSpec with Matchers {

  "The 'triangularNumbers' method" should "return the correct sequence of triangular numbers" in {
    TriangularNumbers.triangularNumbers().take(1) should be(List(1))
    TriangularNumbers.triangularNumbers().take(2) should be(List(1, 3))
    TriangularNumbers.triangularNumbers().take(3) should be(List(1, 3, 6))
    TriangularNumbers.triangularNumbers().take(4) should be(List(1, 3, 6, 10))
    TriangularNumbers.triangularNumbers().take(5) should be(List(1, 3, 6, 10, 15))
    TriangularNumbers.triangularNumbers().take(6) should be(List(1, 3, 6, 10, 15, 21))
    TriangularNumbers.triangularNumbers().take(7) should be(List(1, 3, 6, 10, 15, 21, 28))
  }

}
