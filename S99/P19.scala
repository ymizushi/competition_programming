object P19 {
  def main(args: Array[String]) = {
    println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def rotate[A](n: Int, l: List[A]): List[A] = {
    def innerRotate(count: Int, archived: List[A], rest: List[A]): List[A] = {
      val index = if (count == n) n else l.length + n
      if (count == index) {
        rest ++ archived
      } else {
        innerRotate(count+1, archived :+ rest.head, rest.tail)
      }
    }
    innerRotate(0, List.empty, l)
  }
}
