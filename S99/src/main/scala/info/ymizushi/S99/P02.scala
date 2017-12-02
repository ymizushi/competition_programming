
object P02 {
  def main(args: Array[String]) = {
    println(penultimate(List(1, 1, 2, 3, 5, 8)))
  }

  def penultimate[A](s: Seq[A]): A = {
    if (s.length <= 1) {
      throw new Exception("Invalid list length")
    } else {
      if (s.tail.length == 1) {
        s.head
      } else {
        penultimate(s.tail)
      }
    }
  }
}


