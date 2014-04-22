import org.scalatest._

class PE004LargestPalindromeProductSpec extends FlatSpec with Matchers {

  "The 'isPalindrome' method" should "return true for palindromic numbers" in {
    PE004LargestPalindromeProduct.isPalindrome(1) should be(true)
    PE004LargestPalindromeProduct.isPalindrome(101) should be(true)
    PE004LargestPalindromeProduct.isPalindrome(222) should be(true)
    PE004LargestPalindromeProduct.isPalindrome(440044) should be(true)
    PE004LargestPalindromeProduct.isPalindrome(312213) should be(true)
    PE004LargestPalindromeProduct.isPalindrome(45554) should be(true)
  }

  "The 'isPalindrome' method" should "return false for non-palindromic numbers" in {
    PE004LargestPalindromeProduct.isPalindrome(12) should be(false)
    PE004LargestPalindromeProduct.isPalindrome(103) should be(false)
    PE004LargestPalindromeProduct.isPalindrome(322) should be(false)
    PE004LargestPalindromeProduct.isPalindrome(441084) should be(false)
    PE004LargestPalindromeProduct.isPalindrome(311213) should be(false)
    PE004LargestPalindromeProduct.isPalindrome(45534) should be(false)
  }

  "The 'minNumFromDigits' method" should "return the right numbers" in {
    PE004LargestPalindromeProduct.minNumFromDigits(1) should be(1)
    PE004LargestPalindromeProduct.minNumFromDigits(2) should be(10)
    PE004LargestPalindromeProduct.minNumFromDigits(3) should be(100)
    PE004LargestPalindromeProduct.minNumFromDigits(5) should be(10000)
  }

  "The 'maxNumFromDigits' method" should "return the right numbers" in {
    PE004LargestPalindromeProduct.maxNumFromDigits(1) should be(9)
    PE004LargestPalindromeProduct.maxNumFromDigits(2) should be(99)
    PE004LargestPalindromeProduct.maxNumFromDigits(3) should be(999)
    PE004LargestPalindromeProduct.maxNumFromDigits(5) should be(99999)
  }

  "The 'largestPalindromicNumberOfTwoFactors' method" should "return the right values" in {
    PE004LargestPalindromeProduct.largestPalindromicNumberOfTwoFactors(1) should be(9)
    PE004LargestPalindromeProduct.largestPalindromicNumberOfTwoFactors(2) should be(9009)
    PE004LargestPalindromeProduct.largestPalindromicNumberOfTwoFactors(3) should be(906609)
  }

}
