import org.specs2.mutable.Specification

object PE1MultiplesOf3or5Spec extends Specification {

  "The 'sumOfMultiplesOf3or5Below' method" should {
    "return 23 when the arg is 10" in {
      val result = PE1MultiplesOf3or5.sumOfMultiplesOf3or5Below(10)
      result must beEqualTo (23)
    }
  }

  "The 'sumOfMultiplesOf3or5Below' method" should {
    "return 233168 when the arg is 1000" in {
      val result = PE1MultiplesOf3or5.sumOfMultiplesOf3or5Below(1000)
      result must beEqualTo(233168)
    }
  }

  "The 'sumOfMultiplesOf3or5Below' method" should {
    "return 0 when the arg is 0" in {
      val result = PE1MultiplesOf3or5.sumOfMultiplesOf3or5Below(0)
      result must beEqualTo(0)
    }
  }

  "The 'sumOfMultiplesOf3or5Below' method" should {
    "return 0 when the arg is less than 0" in {
      val result = PE1MultiplesOf3or5.sumOfMultiplesOf3or5Below(-1)
      result must beEqualTo(0)
    }
  }

}
