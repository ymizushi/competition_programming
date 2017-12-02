object P15 {
  def main(args: Array[String]) = {
    println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
  }

  def duplicateN[A](n: Int, l: List[A]): List[A] = {
    l flatMap {e =>
      (1 to n ).map (_ => e)
    }
  }
}

