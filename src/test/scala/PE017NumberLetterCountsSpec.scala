import org.scalatest._

class PE017NumberLetterCountsSpec extends FlatSpec with Matchers {

  "The 'words' method" should "return the correct answer to some examples" in {
    PE017NumberLetterCounts.words(0) should be("zero")
    PE017NumberLetterCounts.words(1) should be("one")
    PE017NumberLetterCounts.words(11) should be("eleven")
    PE017NumberLetterCounts.words(12) should be("twelve")
    PE017NumberLetterCounts.words(13) should be("thirteen")
    PE017NumberLetterCounts.words(14) should be("fourteen")
    PE017NumberLetterCounts.words(15) should be("fifteen")
    PE017NumberLetterCounts.words(16) should be("sixteen")
    PE017NumberLetterCounts.words(17) should be("seventeen")
    PE017NumberLetterCounts.words(18) should be("eighteen")
    PE017NumberLetterCounts.words(19) should be("nineteen")
    PE017NumberLetterCounts.words(20) should be("twenty")
    PE017NumberLetterCounts.words(25) should be("twenty-five")
    PE017NumberLetterCounts.words(31) should be("thirty-one")
    PE017NumberLetterCounts.words(40) should be("forty")
    PE017NumberLetterCounts.words(59) should be("fifty-nine")
    PE017NumberLetterCounts.words(63) should be("sixty-three")
    PE017NumberLetterCounts.words(72) should be("seventy-two")
    PE017NumberLetterCounts.words(88) should be("eighty-eight")
    PE017NumberLetterCounts.words(97) should be("ninety-seven")
    PE017NumberLetterCounts.words(100) should be("one hundred")
    PE017NumberLetterCounts.words(101) should be("one hundred and one")
    PE017NumberLetterCounts.words(111) should be("one hundred and eleven")
    PE017NumberLetterCounts.words(126) should be("one hundred and twenty-six")
    PE017NumberLetterCounts.words(199) should be("one hundred and ninety-nine")
    PE017NumberLetterCounts.words(1000) should be("one thousand")
  }

  it should "return the correct answer to the main problem" in {
    PE017NumberLetterCounts.solveForProblem() should be(21124)
  }

}
