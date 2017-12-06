package info.ymizushi.S99

object P34 {
  implicit class AddIntTo(n: Int) {
    def totient: Int = {
      (1 to n).filter(isCoprimeTo(_)).length
    }

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
}
