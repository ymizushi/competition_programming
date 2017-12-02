object P36 {
  implicit class IntTo(val n: Int) {
    def primeFactorMultiplicity: List[(Int, Int)] = {
      List((1,2))
    }
  }

  def main(args: Array[String]) = {
    println(10.primeFactorMultiplicity)
  }
}
