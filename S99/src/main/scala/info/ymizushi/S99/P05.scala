object P05 {
  def main(args: Array[String]) = {
    println(reverse(List(1,1,2,3,5,8)))
  }


  def reverse[A](s: List[A]): List[A] = {
    s match {
      case Nil => Nil
      case head::tail => reverse(tail) ::: List(head)
    }
  }
}
