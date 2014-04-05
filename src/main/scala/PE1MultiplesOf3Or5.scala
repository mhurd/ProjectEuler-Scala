
object PE1MultiplesOf3Or5 {

  def findSum(below: Int): Int = {
    findSum(below, 3, 5)
  }

  def findSum(below: Int, multiples: Int*) = {
    if (below <= 0) 0 else {
      (for {
          below <- 0.to(below - 1)
          if multiples.exists(below % _ == 0)
        } yield {
          below
        }).reduceLeft(_ + _)
    }
  }

}
