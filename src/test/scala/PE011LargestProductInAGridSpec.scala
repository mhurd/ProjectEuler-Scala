import org.scalatest._
import utils.Timer

class PE011LargestProductInAGridSpec extends FlatSpec with Matchers with Timer {

  // PE011LargestProductInAGrid.maxX(2, grid) should be(4851)

  val grid = List(List( 8,  2, 22),
                  List(49, 37, 99),
                  List(81, 15, 31) )

  "The 'maxX' method" should "return the largest product of sequence length in the X axis" in {
    PE011LargestProductInAGrid.maxX(2, grid) should be(3663) // 37*99
  }

  "The 'maxY' method" should "return the largest product of sequence length in the Y axis" in {
    PE011LargestProductInAGrid.maxY(2, grid) should be(3969) // 49*81
  }

  "The 'maxDiagonals' method" should "return the largest product of sequence length in the diagonals" in {
    PE011LargestProductInAGrid.maxDiagonals(2, grid) should be(2997) // 37*81
  }

  "The 'largestProduct' method" should "return the correct answer for the Project Euler question" in {
    println("Answer takes " + timeInSeconds(() => PE011LargestProductInAGrid.largestProduct(), 3) + " seconds")
    PE011LargestProductInAGrid.largestProduct() should be(70600674)
  }

}
