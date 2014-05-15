import org.scalatest._

class PE015LatticePathsSpec extends FlatSpec with Matchers {

  "The 'solveForProblem' method" should "return the correct answer to some examples" in {
    PE015LatticePaths.solve(2) should be(6)
  }

  it should "return the correct answer to the main problem" in {
    PE015LatticePaths.solveForProblem() should be(BigInt("137846528820"))
  }

}
