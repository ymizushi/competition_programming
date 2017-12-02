object P31 {
  implicit class AddIsPrime(n: Int) {
    def isPrime: Boolean = {
      (1 to n).filter { e =>
        if (n % e == 0) {
          true
        } else {
          false
        }
      }.length == 2
    }
  }

  def main(args: Array[String]) = {
    println(5.isPrime)
    println(11.isPrime)
    println(12.isPrime)
  }
}
