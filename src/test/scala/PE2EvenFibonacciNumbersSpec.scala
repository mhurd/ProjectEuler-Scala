import org.scalatest._

class PE2EvenFibonacciNumbersSpec extends FlatSpec with Matchers {

  "Fib method" should "handle zeros" in {
    PE2EvenFibonacciNumbers.fib(0) should be (0)
  }

  it should "return the correct values for some example cases" in {
    PE2EvenFibonacciNumbers.fib(1) should be(1)
    PE2EvenFibonacciNumbers.fib(2) should be(2)
    PE2EvenFibonacciNumbers.fib(3) should be(3)
    PE2EvenFibonacciNumbers.fib(4) should be(5)
    PE2EvenFibonacciNumbers.fib(5) should be(8)
    PE2EvenFibonacciNumbers.fib(6) should be(13)
    PE2EvenFibonacciNumbers.fib(7) should be(21)
    PE2EvenFibonacciNumbers.fib(8) should be(34)
    PE2EvenFibonacciNumbers.fib(9) should be(55)
    PE2EvenFibonacciNumbers.fib(10) should be(89)
  }

  "sumOfEvenFibonacciNumbersBelow method" should "work" in {
    PE2EvenFibonacciNumbers.sumOfEvenFibonacciNumbersBelow(4000000) should be(4613732)
  }

}
