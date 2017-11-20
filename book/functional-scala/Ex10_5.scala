object Ex10_5 {
  def main(args: Array[String]): Unit = {
    print(foldMap[Int, String](List(1, 2, 3, 4), StringMonoid)("hoge" + _.toString))
    Unit
  }

  def concatenate[A](as: List[A], m: Monoid[A]): A =
    as.foldLeft(m.zero)(m.op(_, _))

  def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B = {
    as.map(f).foldLeft(m.zero)(m.op)
    // 別解: as.foldLeft(m.zero)((b, a) => m.op(b, f(a)))
  }

  def foldLeft[A, B](as: List[A])(zero: B)(f: (B, A) => B): B = {
    foldMap(as, dual(endoMonoid[B]))(a => b => f(b, a))(zero) // notice
  }

  def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B = {
    foldMap(as, dual(endoMonoid[B]))(a => b => f(b, a))(z) // notice
  }
}

trait Monoid[A] {
  def zero: A

  def op(left: A, right: A): A
}

object IntMonoid extends Monoid[Int] {
  def zero = 0

  def op(left: Int, right: Int): Int = left + right
}

object StringMonoid extends Monoid[String] {
  def zero = ""

  def op(left: String, right: String): String = left + right
}

