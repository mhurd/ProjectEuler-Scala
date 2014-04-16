import org.scalatest._

class PE9SpecialPythagoreanTripletSpec extends FlatSpec with Matchers {

  "The 'run' method" should "return the correct value" in {
    PE9SpecialPythagoreanTriplet.run() should be(31875000)
  }

}
