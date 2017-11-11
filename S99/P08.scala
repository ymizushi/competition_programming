object P08 {
  def main(args: Array[String]): Unit = {
    println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    Unit
  }

  def compressA[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case first :: Nil => first :: Nil
      case first :: second :: Nil if first == second => first :: Nil
      case head :: tail => head :: compress(tail)
    }
  }

  def compress[A](list: List[A]): List[A] = {
    def compress1(pre: T, rest: List[T]): List[T] = rest match {
      case x :: xs if pre == x => compress1(pre, xs)
      case x :: xs  => pre :: compress1(x, xs)
      case Nil => pre :: Nil
    }

    list match {
      case x :: xs => compress1(x, xs)
      case Nil => Nil
    }
  }
}
