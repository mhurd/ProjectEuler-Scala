import org.scalatest._

class PE019CountingSundaysSpec extends FlatSpec with Matchers {

  "The 'solveForProblem' method" should "return the correct answer to the problem" in {
    PE019CountingSundays.solveForProblem() should be(23)
  }

}
