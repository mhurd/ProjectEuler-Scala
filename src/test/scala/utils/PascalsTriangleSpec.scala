package utils

import org.scalatest._
import java.lang.ArithmeticException

class PascalsTriangleSpec extends FlatSpec with Matchers with Timer {

  "The 'getValue' method" should "return the correct pascal number" in {
    // 0th row
    PascalsTriangle.getValue(0, 0) should be(1)
    // 4th row - remember the triangle is 0-indexed (both x & y)
    PascalsTriangle.getValue(4, 0) should be(1)
    PascalsTriangle.getValue(4, 1) should be(4)
    PascalsTriangle.getValue(4, 2) should be(6)
    PascalsTriangle.getValue(4, 3) should be(4)
    PascalsTriangle.getValue(4, 4) should be(1)
    // 10th row
    PascalsTriangle.getValue(10, 0) should be(1)
    PascalsTriangle.getValue(10, 1) should be(10)
    PascalsTriangle.getValue(10, 2) should be(45)
    PascalsTriangle.getValue(10, 3) should be(120)
    PascalsTriangle.getValue(10, 4) should be(210)
    PascalsTriangle.getValue(10, 5) should be(252)
    PascalsTriangle.getValue(10, 6) should be(210)
    PascalsTriangle.getValue(10, 7) should be(120)
    PascalsTriangle.getValue(10, 8) should be(45)
    PascalsTriangle.getValue(10, 9) should be(10)
    PascalsTriangle.getValue(10, 10) should be(1)
  }

  it should "throw an ArithmeticException for invalid arguments" in {
    a [ArithmeticException] should be thrownBy( PascalsTriangle.getValue(0, 1) )
    a [ArithmeticException] should be thrownBy( PascalsTriangle.getValue(10, 11) )
    a [ArithmeticException] should be thrownBy( PascalsTriangle.getValue(-1, 0) )
    a [ArithmeticException] should be thrownBy( PascalsTriangle.getValue(1, -1) )
  }

}
