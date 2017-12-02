package info.ymizushi.S99

object P35 {
  implicit class AddIntTo(n: Int) {
    def primeFactors: List[Int] = {
      def innerPrimeFactors(in: Int, divider: Int, archived: List[Int]): List[Int] = {
        if (divider == n) {
          archived
        } else if (in % divider == 0) {
          innerPrimeFactors(in/divider, divider, archived:+divider)
        } else {
          innerPrimeFactors(in, divider+1, archived)
        }
      }
      innerPrimeFactors(n, 2, List[Int]())
    }
  }

  def main(args: Array[String]) = {
    println(315.primeFactors)
  }
}
