package utils

trait Timer {

  def timeInSeconds(f: () => Unit, repetitions: Int): Double = {
    val start1: Double = System.currentTimeMillis()
    (1 to repetitions).foreach(_ => f())
    val stop1: Double = System.currentTimeMillis()
    (stop1 - start1) / repetitions / 1000
  }

}
