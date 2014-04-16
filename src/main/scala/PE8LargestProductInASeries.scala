object PE8LargestProductInASeries {

  // longer as it handles variable consecutive digits and also can return all sets of n digits that
  // have the maximum product if there are more than one
  def findGreatestProduct(digits: String, nConsecutiveDigits: Int): List[(String, Int)] = {
    val r = digits.sliding(nConsecutiveDigits, 1).map(s => {
      (s, s.map(_.toString.toInt).reduceLeft(_ * _))
    }).toList
    val max = r.maxBy[Int](_._2)
    r.filter(_._2 == max._2)
  }

}
