object P18 {
  def main(args: Array[String]) = {
    println(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }


  def slice[A](first: Int, last: Int, l: List[A]): List[A] = {
    def innerSlice(count: Int, archived: List[A], rest: List[A]): List[A] = {
      if (first <= count && count < last) {
        innerSlice(count+1, archived :+ rest.head, rest.tail)
      } else if (count == last) {
        archived
      } else {
        innerSlice(count+1, archived, rest.tail)
      }
    }
    innerSlice(0, List.empty, l)
  }
}
