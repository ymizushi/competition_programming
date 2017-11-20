trait Monoid[A] {
  def op(a1: A, a2: A): A
  def zero: A
}

trait MonoidLaws {
  def monoidLaws[A](m: Monoid[A], gen: Gen[A]): Prop
}

