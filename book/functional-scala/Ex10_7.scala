object Ex10_7 {
  def main(args: Array[String]) = {
    implicit val stringMonoid: Monoid[String] = StringMonoid
    println(foldMapV(Vector("1", "2", "3", "4"))(before => before))
  }

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
