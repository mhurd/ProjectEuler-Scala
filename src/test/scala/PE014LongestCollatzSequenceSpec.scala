import org.scalatest._

class PE014LongestCollatzSequenceSpec extends FlatSpec with Matchers {

  "The 'nextCollatzNumber' method" should "return the correct answer" in {
    PE014LongestCollatzSequence.nextCollatzNumber(13) should be(40)
    PE014LongestCollatzSequence.nextCollatzNumber(40) should be(20)
    PE014LongestCollatzSequence.nextCollatzNumber(20) should be(10)
    PE014LongestCollatzSequence.nextCollatzNumber(10) should be(5)
    PE014LongestCollatzSequence.nextCollatzNumber(5) should be(16)
    PE014LongestCollatzSequence.nextCollatzNumber(16) should be(8)
    PE014LongestCollatzSequence.nextCollatzNumber(8) should be(4)
    PE014LongestCollatzSequence.nextCollatzNumber(4) should be(2)
    PE014LongestCollatzSequence.nextCollatzNumber(2) should be(1)
  }

  "The 'solveForProblem' method" should "return the correct answer" in {
    PE014LongestCollatzSequence.solveForProblem() should be(837799)
  }

}
