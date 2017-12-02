import scala.math.{random, floor} 

object P24 {
  def main(args: Array[String]) = {
    println(lotto(6, 49))
  }

  def lotto(n: Int, m: Int): List[Int] = {
    randomSelect(n, range(1, m))
  }

  def range(start: Int, end: Int): List[Int] = {
    if (start > end) {
      throw new Exception("start must be  less than end")
    } else if (start == end) {
      end :: Nil
    } else {
      start :: range(start+1, end)
    }
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
