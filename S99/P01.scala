object P01 {
  def main(args: Array[String]) = {
    println("Hoge")
    println(last[Int](List(1, 1, 2, 3, 5, 8)).toString)
  }


  def last[A](l: Seq[A]): A = {
    l match {
      case head :: Nil => head
      case _ :: tail => last(tail)
      case _ => throw new Exception("Unknown type")
    }
  }
}
