object P19 {
  def main(args: Array[String]) = {
    println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def rotate[A](n: Int, l: List[A]): List[A] = {
    def innerRotate[A](count: Int, archived: List[A], rest: List[A]): List[A] = {
      if (count == n) {
        rest ++ archived
      } else {
        innerRotate(count+1, archived :+ rest.head, rest.tail)
      }
    }
    innerRotate(0, List.empty, l)
  }
}
