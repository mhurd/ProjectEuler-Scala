import org.scalatest._

class PE020FactorialDigitSumSpec extends FlatSpec with Matchers {

  "The 'solveForProblem' method" should "return the correct answer to the problem" in {
    PE020FactorialDigitSum.solveForProblem() should be(648)
  }

}
