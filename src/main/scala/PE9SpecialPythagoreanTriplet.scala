object PE9SpecialPythagoreanTriplet {

  // A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
  //
  // a^2 + b^2 = c^2
  // For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
  //
  // There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  // Find the product abc.

  def run(): Int = {
    val target = 1000
    val r = for {
      a <- 1 to target
      b <- 1 to (target - a)
      c <- 1 to (target - a - b)
      if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) && (a + b + c == target)
    } yield {
      println("candidate = " + a + "^2 + " + b + "^2 = " + c + "^2")
      a * b * c
    }
    r.head
  }

}
