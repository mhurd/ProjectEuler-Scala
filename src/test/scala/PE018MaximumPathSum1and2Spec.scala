import org.scalatest._

class PE018MaximumPathSum1and2Spec extends FlatSpec with Matchers {

  val testTriangle = Array(
      Array(3),
      Array(7, 4),
      Array(2, 4, 6),
      Array(8, 5, 9, 3)
  )

  "The 'solve' method" should "return the correct answer to some examples" in {
    PE018MaximumPathSum1and2.solve(testTriangle) should be(23)
  }

  it should "return the correct answer to problem 18" in {
    PE018MaximumPathSum1and2.solveForProblem18() should be(1074)
  }

  it should "return the correct answer to problem 67" in {
    PE018MaximumPathSum1and2.solveForProblem67() should be(7273)
  }

}
