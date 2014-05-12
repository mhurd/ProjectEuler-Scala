import org.scalatest._

class PE013LargeSumSpec extends FlatSpec with Matchers {

  "The 'solve' method" should "return the correct answer" in {
    PE013LargeSum.solve() should be("5537376230")
  }

}
