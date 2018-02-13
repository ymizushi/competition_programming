object P49 {
  def gray(n: Int)(implicit cache: scala.collection.mutable.Map[Int, List[String]]): List[String] = {
    def get(n: Int): List[String] = {
      List(0,1).map {
        case 0 => gray(n-1).map("0" + _ )
        case 1 => gray(n-1).reverse.map("1" + _ )
      }.flatten
    }
    n match {
      case 1 => List("0", "1")
      case _ => cache.getOrElseUpdate(n, get(n))
    }
  }

  def main(args: Array[String]): Unit = {
    implicit val cache = scala.collection.mutable.Map[Int, List[String]]()
    println(gray(2))
    println(gray(3))
    println(gray(4))
    println(gray(5))
  }
}
