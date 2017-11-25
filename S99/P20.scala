object P20 {
  def main(args: Array[String]) = {
    println(removeAt(1, List('a, 'b, 'c, 'd)))
  }

  def removeAt[A](n: Int, l: List[A]): (List[A], A) = {
    def innerRemoveAt[A](count: Int, archived: List[A], rest: List[A]): (List[A], A) = {
      if (count == n) {
        (archived ++ rest.tail, rest.head)
      } else {
        innerRemoveAt(count+1, archived :+ rest.head, rest.tail)
      }
    }
    innerRemoveAt(0, List.empty, l)
  }
}
