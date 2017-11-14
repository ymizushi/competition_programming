object P11 {
  def main(args: Array[String]) = {
    println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }


  def encodeModified[A](l: List[A]): List[Any] = {
    encode(l).map { 
      case (f, s) if f > 1 => {
        (f, s)
      }
      case (f, s) if f == 1 => {
        s
      }
      case _ => {
        throw new Exception("empty list is not permitted")
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
