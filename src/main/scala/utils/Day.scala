package utils

object Day extends Enumeration {
  type Day = Value
  val MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY = Value

  def next(day: Day): Day = {
    day match {
      case MONDAY => TUESDAY
      case TUESDAY => WEDNESDAY
      case WEDNESDAY => THURSDAY
      case THURSDAY => FRIDAY
      case FRIDAY => SATURDAY
      case SATURDAY => SUNDAY
      case SUNDAY => MONDAY
    }
  }

}
