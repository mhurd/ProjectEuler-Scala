import utils.Primes

object PE5SmallestMultiple {

  def isEven(n: Long): Boolean = n % 2 == 0

  def isOdd(n: Long): Boolean = !isEven(n)

  // if there are even numbers in the range to check then the result
  // must be even too - this cuts time in about half
  def shortCutEvenOdd(r: Range, n: Long): Boolean = {
    if (r.exists(isEven(_))) isEven(n) else isOdd(n)
  }

  def smallestEvenlyDivisibleNumberForAll(r: Range): Int = {
    // remember to add 1 to the result as the index is 0 based
    Primes.naturalNumberStream(1).iterator.indexWhere(n => shortCutEvenOdd(r, n) &&  r.forall(rn => n % rn == 0))+1
  }

}
