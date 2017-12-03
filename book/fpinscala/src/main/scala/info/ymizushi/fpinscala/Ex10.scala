object Ex10 {
  def main(args: Array[String]) = {
    implicit val stringMonoid: Monoid[String] = StringMonoid
    println(foldMapV(Vector("1", "2", "3", "4"))(before => before))

    val endoMonoid= new EndoMonoid[Int]()
    println(endoMonoid.op((x:Int) => x+x, (y: Int) => y+y))

    val optionMonoid= new OptionMonoid[Int]()
    println(optionMonoid.op(Some(1), None))
    println(optionMonoid.op(Some(1), Some(2)))
    println(optionMonoid.op(None, Some(2)))

    val intAddition = new IntAdditionMonoid
    val intMultipication = new IntMultiplicationMonoid
    println(intAddition.op(4, 8))

    // Exercise 10.6 
    // RETRY:
  }


  // Exercise 10.5
  def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B = {
    as.map(f).foldLeft(m.zero)(m.op)
    // 別解: as.foldLeft(m.zero)((b, a) => m.op(b, f(a)))
  }


  // Exercise 10.10
  // FIX:
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

  // Execise 10.11
  // RETRY:
  // def count(s: String): Int = {
  //   def wc(c: Char): WC = {
  //     if (c.isWhitespace)
  //       Part("", 0, "")
  //     else
  //       Stub(c.toString)
  //   }
  //   def unstub(s: String) = s.length min 1
  //   foldMapV(s.toIndexedSeq, wcMonoid)(wc) match {
  //     case Stub(s) => unstub(s)
  //     case Part(l, w, r) => unstub(l) + w + unstub(r)
  //   }
  // }

  // Exercise 10.7
  // RETRY:
  def foldMapV[A, B](as: IndexedSeq[A])(f: A => B)(implicit m: Monoid[B]): B = {
    if (as.length == 0)
      m.zero
    else if (as.length == 1)
      f(as(0))
    else {
      val (l, r) = as.splitAt(as.length / 2)
      m.op(foldMapV(l)(f), foldMapV(r)(f))
    }
  }


  // Exercise 10.8 
  // RETRY:

  // Exercise 10.9 
  // RETRY:
  
  // def main(args: Array[String]): Unit = {
  //   print(foldMap[Int, String](List(1, 2, 3, 4), StringMonoid)("hoge" + _.toString))
  //   Unit
  // }

  // def concatenate[A](as: List[A], m: Monoid[A]): A =
  //   as.foldLeft(m.zero)(m.op(_, _))
}

trait Monoid[A] {
  def op(left: A, right: A): A
  def zero: A
}

object IntMonoid extends Monoid[Int] {
  def op(left: Int, right: Int): Int = left + right
  def zero: Int = 0
}

object StringMonoid extends Monoid[String] {
  def op(left: String, right: String): String = left + right
  def zero: String = ""
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


// Excercise 10.1
class IntAdditionMonoid extends Monoid[Int] {
  def op(a1: Int, a2: Int): Int =
    a1 + a2

  def zero = 0
}

class IntMultiplicationMonoid extends Monoid[Int] {
  def op(a1: Int, a2: Int): Int =
    a1 * a2

  def zero = 1
}

class BooleanOrMonoid extends Monoid[Boolean] {
  def op(a1: Boolean, a2: Boolean): Boolean =
    a1 || a2

  def zero = false
}

class BooleanAndMonoid extends Monoid[Boolean] {
  def op(a1: Boolean, a2: Boolean): Boolean =
    a1 && a2

  def zero = true
}

// Exercise 10.2
class OptionMonoid[A] extends Monoid[Option[A]] {
  def op(a1: Option[A], a2: Option[A]): Option[A]
    = a1 orElse a2

  def zero = None
}

// Exercise 10.3
class EndoMonoid[A] extends Monoid[A => A] {
  def op(a1: A => A, a2: A => A): A => A
    = a1 compose a2

  def zero = (x: A) => x
}

// Exercise 10.4
// RETRY:
// trait MonoidLaws {
//   def monoidLaws[A](m: Monoid[A], gen: Gen[A]): Prop
// }

// Exercise 10.5
