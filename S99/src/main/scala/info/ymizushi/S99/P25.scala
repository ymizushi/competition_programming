import scala.math.{random, floor}

object P25 {
  def main(args: Array[String]) = {
    println(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
  }

  def randomPermute[A](l: List[A]): List[A] = {
    randomSelect(l.length, l)
  }

  def randomSelect[A](n: Int, l: List[A]): List[A] = {
    if (n == 0) {
      Nil
    } else {
      val index = floor(random * l.length).toInt
      val (rest, target) = removeAt(index, l)
      target :: randomSelect(n-1, rest)
    }
  }

  def removeAt[A](n: Int, l: List[A]): (List[A], A) = {
    def innerRemoveAt(count: Int, archived: List[A], rest: List[A]): (List[A], A) = {
      if (count == n) {
        (archived ++ rest.tail, rest.head)
      } else {
        innerRemoveAt(count+1, archived :+ rest.head, rest.tail)
      }
    }
    innerRemoveAt(0, List.empty, l)
  }
}
