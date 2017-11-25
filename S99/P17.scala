object P17 {
  def main(args: Array[String]) = {
    println(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def split[A](n: Int, l: List[A]): (List[A], List[A]) = {
    def innerSplit[A](n: Int, archieved: List[A], rest: List[A]): (List[A], List[A]) = {
      n match {
        case 0 => (archieved, rest)
        case _ => innerSplit(n-1, archieved :+ rest.head, rest.tail)
      }
    }
    innerSplit(n, List.empty, l)
  }
}
