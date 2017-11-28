
object Ex10_11 {
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

  // RETRY
  def count(s: String): Int = {
    def wc(c: Char): WC = {
      if (c.isWhitespace)
        Part("", 0, "")
      else
        Stub(c.toString)
    }

    def unstub(s: String) = s.length min 1

    foldMapV(s.toIndexedSeq, wcMonoid)(wc) match {
      case Stub(s) => unstub(s)
      case Part(l, w, r) => unstub(l) + w + unstub(r)
    }
  }
  def main(args: Array[String]) = {
    println(wc("hoge piyo fuga fuga piyo"))
  }
}

trait Monoid[A] {
  def zero: A
  def op(left: A, right: A): A
}


sealed trait WC {
  def wc: Int

}
case class Stub(chars: String) extends WC {
  def wc = 0
}
case class Part(lStub: String, words: Int, rStub: String) extends WC {
  def wc = words
}


