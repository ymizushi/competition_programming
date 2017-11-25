import scala.annotation.tailrec

object P16 {
  def main(args: Array[String]) = {
    println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def drop[A](n: Int, l: List[A]): List[A] = {
    @tailrec
    def innerDrop(n: Int, archieved: List[A], rest: List[A]): List[A] = {
      (n, rest) match {
        case (1, r) => innerDrop(n-1, archieved, r.tail)
        case (_, rest) if rest.length == 0 => archieved
        case (_, r) => innerDrop(n-1, archieved :+ r.head, r.tail)
      }
    }
    innerDrop(n, List.empty, l)
  }
}
