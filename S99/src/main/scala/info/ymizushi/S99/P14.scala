object P14 {
  def main(args: Array[String]) = {
    println(duplicate(List('a, 'b, 'c, 'c, 'd)))
  }

  def duplicate[A](l: List[A]): List[A] = {
    encodeDirect(l).flatMap {
      case (count, e) => (1 to count*2).map(_ => e)
    }
  }

  def encodeDirect[A](l: List[A]): List[(Int, A)] = {
    def encodeDirectInner(pre: A, count: Int, rest: List[A]): List[(Int, A)] = {
      rest match {
        case head :: tail if head == pre => encodeDirectInner(head, count+1, tail)
        case head :: tail => (count, pre) :: encodeDirectInner(head, 1, tail)
        case Nil  => List((count, pre))
      }
    }
    l match {
      case head :: tail => encodeDirectInner(head, 1, tail)
      case _ => List.empty 
    }
  }
}
