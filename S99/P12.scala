object P12 {
  def main(args: Array[String]) = {
    println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
  }

  def decode[A](l: List[(Int, A)]): List[A] = {
    l.flatMap {
      case (n, c) => {
        List.fill(n)(c)
      }
    }
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

