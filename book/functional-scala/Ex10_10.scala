object Ex10_10 {
  val wcMonoid: Monoid[WC] = new Monoid[WC] {
    def zero: WC = Stub("")

    def op(left: WC, right: WC): WC = {
      (left, right) match {
        case (Stub(leftChars), Stub(rightChars)) => Part(leftChars, 0, rightChars)
        case (Stub(leftChars), Part(lStub, words, rStub)) => Part(leftChars+lStub, words, rStub)
        case (Part(lStub, words, rStub), Stub(rightChars)) =>Part(lStub, words, rStub+rightChars)
        case (Part(lStub, leftWords, _), Part(_, rightWords, rStub)) => Part(lStub, leftWords+rightWords+1, rStub)
      }
    }
  }

  def main(args: Array[String]) = {
  }
}

trait Monoid[A] {
  def zero: A
  def op(left: A, right: A): A
}


sealed trait WC
case class Stub(chars: String) extends WC
case class Part(lStub: String, words: Int, rStub: String) extends WC


