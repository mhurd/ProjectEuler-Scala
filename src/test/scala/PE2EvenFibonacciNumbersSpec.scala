import org.scalatest._

class PE2EvenFibonacciNumbersSpec extends FlatSpec with Matchers {

  "Fib method" should "handle zeros" in {
    PE2EvenFibonacciNumbers.fib(0) should be(0)
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

  it should "handle large numbers" in {
    PE2EvenFibonacciNumbers.fib(50) should be(BigInt("20365011074"))
    PE2EvenFibonacciNumbers.fib(100) should be(BigInt("573147844013817084101"))
    PE2EvenFibonacciNumbers.fib(200) should be(BigInt("453973694165307953197296969697410619233826"))
    PE2EvenFibonacciNumbers.fib(400) should be(BigInt("284812298108489611757988937681460995615380088782304890986477195645969271404032323901"))
  }

  it should "handle stupidly large numbers" in {
    PE2EvenFibonacciNumbers.fib(4000) should be(BigInt("64574884490948173531376949015369595644413900640151342708407577598177210359034088914449477807287241743760741523783818897499227009742183152482019062763550798743704275106856470216307593623057388506776767202069670477506088895294300509291166023947866841763853953813982281703936665369922709095308006821399524780721049955829191407029943622087779296459174012610148659520381170452591141331949336080577141708645783606636081941915217355115810993973945783493983844592749672661361548061615756595818944317619922097369917676974058206341892088144549337974422952140132621568340701016273422727827762726153066303093052982051757444742428033107522419466219655780413101759505231617222578292486081002391218785189299675757766920269402348733644662725774717740924068828300186439425921761082545463164628807702653752619616157324434040342057336683279284098590801501"))
    val _99999 = PE2EvenFibonacciNumbers.fib(99999)
    val _100000 = PE2EvenFibonacciNumbers.fib(100000)
    val _100001 = PE2EvenFibonacciNumbers.fib(100001)
    // these numbers get a bit big to physically put here, just do some heuristic checks
    // to make sure things work
    _99999 < _100000 && _100000 < _100001 should be(true)
  }

  "sumOfEvenFibonacciNumbersBelow method" should "work" in {
    PE2EvenFibonacciNumbers.sumOfEvenFibonacciNumbersBelow(4000000) should be(4613732)
  }

}
