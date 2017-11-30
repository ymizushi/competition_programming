object P33 {
  implicit class AddIntToIsCoprimeTo(n: Int) {
    def isCoprimeTo(m: Int): Boolean = {
      n.gcd(m) == 1
    }

    def gcd(m: Int): Int = {
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

  def main(args: Array[String]) = {
    println(35.isCoprimeTo(64))
  }
}
