object P22 {
  def main(args: Array[String]) = {
    println(range(4, 9))
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
}
