object P50 {
  def main(args: Array[String]): Unit = {
    println(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))))
  }

  def huffman(l: List[(String, Int)]): List[(String, String)] = {
    val sorted = l.sortBy(_._2).reverse
    val length = sorted.length
    val result = sorted.zipWithIndex.map {
      case (s: (String, Int), i: Int) => {
        if (i == 0) {
          (s._1, "0")
        } else if (length == i+1) {
          (s._1, "1" * i + "1")
        
        } else {
          (s._1, "1" * i + "0")
        }
      }
    }
  }
}
