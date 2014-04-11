import org.scalatest._

class PE4LargestPalindromeProductSpec extends FlatSpec with Matchers {

  "The 'isPalindrome' method" should "return true for palindromic numbers" in {
    PE4LargestPalindromeProduct.isPalindrome(1) should be(true)
    PE4LargestPalindromeProduct.isPalindrome(101) should be(true)
    PE4LargestPalindromeProduct.isPalindrome(222) should be(true)
    PE4LargestPalindromeProduct.isPalindrome(440044) should be(true)
    PE4LargestPalindromeProduct.isPalindrome(312213) should be(true)
    PE4LargestPalindromeProduct.isPalindrome(45554) should be(true)
  }

  "The 'isPalindrome' method" should "return false for non-palindromic numbers" in {
    PE4LargestPalindromeProduct.isPalindrome(12) should be(false)
    PE4LargestPalindromeProduct.isPalindrome(103) should be(false)
    PE4LargestPalindromeProduct.isPalindrome(322) should be(false)
    PE4LargestPalindromeProduct.isPalindrome(441084) should be(false)
    PE4LargestPalindromeProduct.isPalindrome(311213) should be(false)
    PE4LargestPalindromeProduct.isPalindrome(45534) should be(false)
  }

  "The 'minNumFromDigits' method" should "return the right numbers" in {
    PE4LargestPalindromeProduct.minNumFromDigits(1) should be(1)
    PE4LargestPalindromeProduct.minNumFromDigits(2) should be(10)
    PE4LargestPalindromeProduct.minNumFromDigits(3) should be(100)
    PE4LargestPalindromeProduct.minNumFromDigits(5) should be(10000)
  }

  "The 'maxNumFromDigits' method" should "return the right numbers" in {
    PE4LargestPalindromeProduct.maxNumFromDigits(1) should be(9)
    PE4LargestPalindromeProduct.maxNumFromDigits(2) should be(99)
    PE4LargestPalindromeProduct.maxNumFromDigits(3) should be(999)
    PE4LargestPalindromeProduct.maxNumFromDigits(5) should be(99999)
  }

  "The 'largestPalindromicNumberOfTwoFactors' method" should "return the right values" in {
    PE4LargestPalindromeProduct.largestPalindromicNumberOfTwoFactors(1) should be(9)
    PE4LargestPalindromeProduct.largestPalindromicNumberOfTwoFactors(2) should be(9009)
    PE4LargestPalindromeProduct.largestPalindromicNumberOfTwoFactors(3) should be(906609)
  }

}
