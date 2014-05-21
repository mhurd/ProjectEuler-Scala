package utils

object Month extends Enumeration {
  type Month = Value
  val JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER = Value

  def isLeapYear(year: Int): Boolean = {
    if (year % 4 == 0) year % 100 != 0 || year % 400 == 0 else false
  }

  def days(month: Month, year: Int): Int = {
    month match {
      case JANUARY => 31
      case FEBRUARY => if (isLeapYear(year)) 29 else 28
      case MARCH => 31
      case APRIL => 30
      case MAY => 31
      case JUNE => 30
      case JULY => 31
      case AUGUST => 31
      case SEPTEMBER => 30
      case OCTOBER => 31
      case NOVEMBER => 30
      case DECEMBER => 31
    }
  }

  def next(month: Month): Month = {
    month match {
      case JANUARY => FEBRUARY
      case FEBRUARY => MARCH
      case MARCH => APRIL
      case APRIL => MAY
      case MAY => JUNE
      case JUNE => JULY
      case JULY => AUGUST
      case AUGUST => SEPTEMBER
      case SEPTEMBER => OCTOBER
      case OCTOBER => NOVEMBER
      case NOVEMBER => DECEMBER
      case DECEMBER => JANUARY
    }
  }

}
