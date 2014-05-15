import org.scalatest._

class PE016PowerDigitSumSpec extends FlatSpec with Matchers {

  "The 'solveForProblem' method" should "return the correct answer to some examples" in {
    PE016PowerDigitSum.solve(2) should be(4)
    PE016PowerDigitSum.solve(3) should be(8)
    PE016PowerDigitSum.solve(4) should be(7) // (i.e. 16 = 1 + 6)
    PE016PowerDigitSum.solve(16) should be(25) // (i.e. 65536 = 6 + 5 + 5 + 3 + 6)
    PE016PowerDigitSum.solve(15) should be(26) // (i.e. 32768 = 3 + 2 + 7 + 6 + 8)
  }

  it should "return the correct answer to the main problem" in {
    PE016PowerDigitSum.solveForProblem() should be(BigInt("1366"))
  }

}
