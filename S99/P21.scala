object P21 {
  def main(args: Array[String]) = {
    println(insertAt('new, 1, List('a, 'b, 'c, 'd)))
  }

  def insertAt[A](symbol: A, index: Int, list: List[A]): List[A] = {
    def innerInsertAt(count: Int, archived: List[A], rest: List[A]): List[A] = {
      count match {
        case _ if count == index => {
          (archived :+ symbol) ++ rest
        }
        case _ if index > list.length - 1 => {
          throw new Exception("index is out of range.")
        }
        case _  => {
          innerInsertAt(count+1, archived :+ rest.head, rest.tail)
        }
      }
    }
    innerInsertAt(0, List.empty, list)
  }
}
