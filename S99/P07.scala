object P07 {
  def flatten(l: List[_]): List[Any] = {
    l match {
      case Nil => Nil
      case (head: List[_]) :: tail => flatten(head) ++ flatten(tail)
      case head::tail => head :: flatten(tail)
    }
  }

  def main(args: Array[String]) = {
    println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  }

}
