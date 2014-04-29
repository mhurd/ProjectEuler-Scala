import org.scalatest._

class PE011LargestProductInAGridSpec extends FlatSpec with Matchers {

  // PE011LargestProductInAGrid.maxX(2, grid) should be(4851)

  val grid = Array( Array( 8,  2, 22),
                    Array(49, 49, 99),
                    Array(81, 49, 31) )

  "The 'maxX' method" should "return the largest product of sequence length in the X axis" in {
    PE011LargestProductInAGrid.maxX(2, grid) should be(4851)
  }

  "The 'maxY' method" should "return the largest product of sequence length in the Y axis" in {
    PE011LargestProductInAGrid.maxY(2, grid) should be(3969)
  }

  "The 'maxSEDiagonals' method" should "return the largest product of sequence length in the South-East diagonal" in {
    PE011LargestProductInAGrid.maxSEDiagonals(2, grid) should be(2401)
  }

}
