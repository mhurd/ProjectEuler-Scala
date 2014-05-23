package utils

import scala.collection.GenTraversable

object Scratch extends Timer {

  def streams1() {
    def process[A](x: GenTraversable[A], f: A => A): GenTraversable[A] = {
      x.map(p => f(p)).take(100)
    }
    val big = 2000000
    val reps = 2
    val f = (n: Int) => n + 1
    println("'to' in seconds = " + timeInSeconds(() => process(1 to big, f), reps))
    println("'Stream.range' in seconds = " + timeInSeconds(() => process(Stream.range(1, big), f), reps)) // <- much faster
  }

  def main(args: Array[String]) {
    streams1()
  }

}
