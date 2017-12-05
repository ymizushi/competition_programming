package info.ymizushi.S99

object P37 {
  def phi(n: Int): Int = {
    import P36.AddInt
    val l = n.primeFactorMultiplicity
    l.map(t => {
      val p: Int = t._1
      val m: Int = t._2
      val result = (p-1) * Math.pow(p, m-1)
      result.toInt
    }).foldLeft(1){(x, y) => x * y}
  }
}
