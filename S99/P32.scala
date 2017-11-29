object P32 {
  def main(args: Array[String]) = {
    println(gcd(36, 63))
  }

  def gcd(n: Int, m: Int): Int = {
    commonMultiple(n).filter { e =>
      if (commonMultiple(m).contains(e)) {
        true
      } else {
        false
      }
    }.last
  }

  def commonMultiple(n: Int): List[Int] = {
    (1 to n).toList.filter(e => n % e  == 0)
  }
}
