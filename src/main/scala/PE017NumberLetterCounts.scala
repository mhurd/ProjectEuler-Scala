import utils.Timer

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19
 * letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred
 * and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 *
 * https://projecteuler.net/problem=17
 */
object PE017NumberLetterCounts extends Timer {

  def units(digit: Char): String = {
    digit match {
      case '0' => "zero"
      case '1' => "one"
      case '2' => "two"
      case '3' => "three"
      case '4' => "four"
      case '5' => "five"
      case '6' => "six"
      case '7' => "seven"
      case '8' => "eight"
      case '9' => "nine"
      case _ => throw new IllegalArgumentException("Not a valid digit: " + digit)
    }
  }

  def tens(digit: Char): String = {
    digit match {
      case '2' => "twenty"
      case '3' => "thirty"
      case '4' => "forty"
      case '5' => "fifty"
      case '6' => "sixty"
      case '7' => "seventy"
      case '8' => "eighty"
      case '9' => "ninety"
      case _ => throw new IllegalArgumentException("Not a valid digit: " + digit)
    }
  }

  def lessThan20(digits: String): String = {
    digits match {
      case "00" => ""
      case "01" => "one"
      case "02" => "two"
      case "03" => "three"
      case "04" => "four"
      case "05" => "five"
      case "06" => "six"
      case "07" => "seven"
      case "08" => "eight"
      case "09" => "nine"
      case "10" => "ten"
      case "11" => "eleven"
      case "12" => "twelve"
      case "13" => "thirteen"
      case "14" => "fourteen"
      case "15" => "fifteen"
      case "16" => "sixteen"
      case "17" => "seventeen"
      case "18" => "eighteen"
      case "19" => "nineteen"
      case _ => throw new IllegalArgumentException("Digits are not less than 20: " + digits)
    }
  }

  def lastPair(n: String): String = {
    val nArray = n.toCharArray
    if (n.toInt <= 19) lessThan20(n.toString) else {
      if (nArray(1) == '0') tens(nArray(0)) else tens(nArray(0)) + "-" + units(nArray(1))
    }
  }

  def words(n: Int): String = {
    n.toString.length match {
      case 1 => units(n.toString.head)
      case 2 => lastPair(n.toString)
      case 3 => {
        val lp = lastPair(n.toString.tail)
        val end = if (lp.length > 0) " and " + lp else ""
        units(n.toString.head) + " hundred" + end
      }
      case 4 => "one thousand"
    }
  }

  def solveForProblem(): Int = {
    (1 to 1000).map(words(_).filter(c => c != ' ' && c != '-').length).sum
  }

}
