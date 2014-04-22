/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * https://projecteuler.net/problem=4
 */
object PE004LargestPalindromeProduct {

  def isPalindrome(n: Int): Boolean = {
    n.toString.reverse.equals(n.toString)
  }

  def minNumFromDigits(l: Int): Int = {
    java.lang.Integer.parseInt(String.valueOf(('1' :: List.fill(l - 1)('0')).toArray))
  }

  def maxNumFromDigits(l: Int): Int = {
    java.lang.Integer.parseInt(String.valueOf(Array.fill(l)('9')))
  }

  def largestPalindromicNumberOfTwoFactors(factorDigits: Int): Long = {
    val min = minNumFromDigits(factorDigits)
    val max = maxNumFromDigits(factorDigits)
    val ps = for {
      l <- min to max
      r <- min to max
      p = l * r
      if (isPalindrome(p))
    } yield p
    ps.max
  }

}
