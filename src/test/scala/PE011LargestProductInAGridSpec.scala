import org.scalatest._
import utils.Timer

class PE011LargestProductInAGridSpec extends FlatSpec with Matchers with Timer {

  val grid = Array( Array( 8,  2, 22),
                    Array(49, 37, 99),
                    Array(81, 15, 31) )

  "The 'largestProduct' method" should "return the correct answer for the Project Euler question" in {
    println("Answer takes " + timeInSeconds(() => PE011LargestProductInAGrid.largestProduct(), 3) + " seconds")
    PE011LargestProductInAGrid.largestProduct() should be(70600674)
  }

}
