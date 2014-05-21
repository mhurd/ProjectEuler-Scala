import utils.{Month, Day, Timer}
import utils.Month._
import utils.Day._

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 *
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 * https://projecteuler.net/problem=19
 *
 */
object PE019CountingSundays extends Timer {

  case class Date(date: Int, day: Day, month: Month, year: Int) {

    override def toString: String = {
      day + " " + date + "-" + month + "-" + year
    }

  }

  def dayIterator() = new Iterator[Date] {

    private var year: Int = 1900
    private var month: Month = JANUARY
    private var day: Day = MONDAY

    private var date: Int = 1

    override def next(): Date = {
      date = date + 1
      day = Day.next(day)
      if (date > Month.days(month, year)) {
        date = 1
        month = Month.next(month)
      }
      if (date == 1 && month == JANUARY) {
        year = year + 1
      }
      Date(date, day, month, year)
    }

    override def hasNext: Boolean = true

  }

  def solveForProblem(): Int = {
    dayIterator().takeWhile(date => date.year < 2001).count(date => date.year >= 1901 && (date.date == 1 && date.day == SUNDAY))
  }

}
