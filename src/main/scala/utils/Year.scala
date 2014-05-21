package utils

import utils.Month._

object Year {

  def days(year: Int): Int = {
    Month.days(JANUARY, year) +
      Month.days(FEBRUARY, year) +
      Month.days(MARCH, year) +
      Month.days(APRIL, year) +
      Month.days(MAY, year) +
      Month.days(JUNE, year) +
      Month.days(JULY, year) +
      Month.days(AUGUST, year) +
      Month.days(SEPTEMBER, year) +
      Month.days(OCTOBER, year) +
      Month.days(NOVEMBER, year) +
      Month.days(DECEMBER, year)
  }

}
