object P03 {
  def main(args: Array[String]) = {
    println(nth(2,List(1,1,2,3,5,8)))
  }

  def nth(num: Int, seq: Seq[Int]): Int = {
    if (num == 0) 
      seq.head
    else 
      nth(num-1, seq.tail)
  }
}
