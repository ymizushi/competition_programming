package info.ymizushi.S99

object P38 {
  def phiByP34(n: Int): Int = {
    import P34.AddIntTo
    n.totient
  }

  def phiByP37(n: Int): Int = {
    P37.phi(n)
  }
}
