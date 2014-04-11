import org.scalatest._

class PE5SmallestMultipleSpec extends FlatSpec with Matchers {

  "The 'smallestEvenlyDivisibleNumberForAll' method" should "return the correct value" in {
    PE5SmallestMultiple.smallestEvenlyDivisibleNumberForAll(1 to 10) should be(2520)
    PE5SmallestMultiple.smallestEvenlyDivisibleNumberForAll(1 to 20) should be(232792560)
  }

  "The 'isEven' method" should "return true for even values and false for odd values" in {
    PE5SmallestMultiple.isEven(1) should be(false)
    PE5SmallestMultiple.isEven(2) should be(true)
    PE5SmallestMultiple.isEven(3) should be(false)
    PE5SmallestMultiple.isEven(4) should be(true)
  }

  "The 'isOdd' method" should "return false for even values and true for odd values" in {
    PE5SmallestMultiple.isOdd(1) should be(true)
    PE5SmallestMultiple.isOdd(2) should be(false)
    PE5SmallestMultiple.isOdd(3) should be(true)
    PE5SmallestMultiple.isOdd(4) should be(false)
  }

  "The 'shortCutEvenOdd' method" should "return true if the range contains an even number and the number arg is even and vice-versa" in {
    PE5SmallestMultiple.shortCutEvenOdd(1 to 10, 2) should be(true)
    PE5SmallestMultiple.shortCutEvenOdd(3 to 4, 2) should be(true)
    PE5SmallestMultiple.shortCutEvenOdd(1 to 10, 3) should be(false)
    PE5SmallestMultiple.shortCutEvenOdd(1 to 10, 7) should be(false)
    PE5SmallestMultiple.shortCutEvenOdd(3 to 3, 3) should be(true)
  }

}
