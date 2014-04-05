import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

object PE1MultiplesOf3Or5Spec extends Specification {

  "The 'findSum' method" should {
    "return 23 when the arg is 10" in {
      val result = PE1MultiplesOf3Or5.findSum(10)
      result must beEqualTo (23)
    }
  }

  "The 'findSum' method" should {
    "return 233168 when the arg is 1000" in {
      val result = PE1MultiplesOf3Or5.findSum(1000)
      result must beEqualTo(233168)
    }
  }

  "The 'findSum' method" should {
    "return 0 when the arg is 0" in {
      val result = PE1MultiplesOf3Or5.findSum(0)
      result must beEqualTo(0)
    }
  }

  "The 'findSum' method" should {
    "return 0 when the arg is less than 0" in {
      val result = PE1MultiplesOf3Or5.findSum(-1)
      result must beEqualTo(0)
    }
  }

}
