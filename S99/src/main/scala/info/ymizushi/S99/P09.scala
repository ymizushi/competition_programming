object P09 {
  def main(args: Array[String]) = {
    println(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  def pack[A](l: List[A]): List[List[A]] = {
    l match {
      case Nil => List(List())
      case _ => {
        // a, a , a ,b,b,b,b
        // (aaaa), (bbbb(cccc)
        val (packed, next) = l.span(_ == l.head)
        next match {
          case Nil => List(packed)
          case _ => packed :: pack(next)
        }
      }
    }

  }
}
