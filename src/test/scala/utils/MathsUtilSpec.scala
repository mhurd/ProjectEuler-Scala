package utils

import org.scalatest._

class MathsUtilSpec extends FlatSpec with Matchers with Timer {

  "The 'factorial' method" should "return the correct factorial" in {
    MathsUtil.factorial(0) should be(1)
    MathsUtil.factorial(1) should be(1)
    MathsUtil.factorial(2) should be(2)
    MathsUtil.factorial(3) should be(6)
    MathsUtil.factorial(4) should be(24)
    MathsUtil.factorial(5) should be(120)
    MathsUtil.factorial(10) should be(3628800)
  }

}
