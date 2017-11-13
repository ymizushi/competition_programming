object P10 {
  def main(args: Array[String]) = {
    println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  def encode[A](l: List[A]): List[(Int, A)] = {
    pack(l).map { e =>
      (e.length, e.head)
    }
  }

  def pack[A](l: List[A]): List[List[A]] = {
    l match {
      case Nil => List(List())
      case _ => {
        val (packed, next) = l.span(_ == l.head)
        next match {
          case Nil => List(packed)
          case _ => packed :: pack(next)
        }
      }
    }
  }
}
