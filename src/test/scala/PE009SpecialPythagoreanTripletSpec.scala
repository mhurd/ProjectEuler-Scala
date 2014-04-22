import org.scalatest._

class PE009SpecialPythagoreanTripletSpec extends FlatSpec with Matchers {

  "The 'run' method" should "return the correct value" in {
    PE009SpecialPythagoreanTriplet.run() should be(31875000)
  }

}
