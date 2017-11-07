object P04 {
  def main(args: Array[String]) = {
    println(length(List(1,1,2,3,5,8)))
  }

  def length[A](seq: Seq[A]): Int = {
    seq match {
      case Nil => 0
      case _::Nil => 1
      case _::tail => 1 + length(tail)
    }

  }
}
