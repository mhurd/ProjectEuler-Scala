import org.scalatest._

class PE005SmallestMultipleSpec extends FlatSpec with Matchers {

  "The 'smallestEvenlyDivisibleNumberForAll' method" should "return the correct value" in {
    PE005SmallestMultiple.smallestEvenlyDivisibleNumberForAll(1 to 10) should be(2520)
    PE005SmallestMultiple.smallestEvenlyDivisibleNumberForAll(1 to 20) should be(232792560)
  }

  "The 'isEven' method" should "return true for even values and false for odd values" in {
    PE005SmallestMultiple.isEven(1) should be(false)
    PE005SmallestMultiple.isEven(2) should be(true)
    PE005SmallestMultiple.isEven(3) should be(false)
    PE005SmallestMultiple.isEven(4) should be(true)
  }

  "The 'isOdd' method" should "return false for even values and true for odd values" in {
    PE005SmallestMultiple.isOdd(1) should be(true)
    PE005SmallestMultiple.isOdd(2) should be(false)
    PE005SmallestMultiple.isOdd(3) should be(true)
    PE005SmallestMultiple.isOdd(4) should be(false)
  }

  "The 'shortCutEvenOdd' method" should "return true if the range contains an even number and the number arg is even and vice-versa" in {
    PE005SmallestMultiple.shortCutEvenOdd(1 to 10, 2) should be(true)
    PE005SmallestMultiple.shortCutEvenOdd(3 to 4, 2) should be(true)
    PE005SmallestMultiple.shortCutEvenOdd(1 to 10, 3) should be(false)
    PE005SmallestMultiple.shortCutEvenOdd(1 to 10, 7) should be(false)
    PE005SmallestMultiple.shortCutEvenOdd(3 to 3, 3) should be(true)
  }

}
