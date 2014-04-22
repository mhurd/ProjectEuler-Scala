import org.scalatest._

class PE001MultiplesOf3or5Spec extends FlatSpec with Matchers {

  "The 'sumOfMultiplesOf3or5Below' method" should "return the following values" in {
    PE001MultiplesOf3or5.sumOfMultiplesOf3or5Below(10) should be(23)
    PE001MultiplesOf3or5.sumOfMultiplesOf3or5Below(1000) should be(233168)
    PE001MultiplesOf3or5.sumOfMultiplesOf3or5Below(0) should be(0)
  }

}
