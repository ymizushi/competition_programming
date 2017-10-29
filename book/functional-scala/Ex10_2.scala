trait Monoid[A] {
  def op(a1: A, a2: A): A
  def zero: A
}

class OptionMonoid[A] extends Monoid[Option[A]] {
  def op(a1: Option[A], a2: Option[A]): Option[A]
    = a1 orElse a2

  def zero = None
}


object Main {
  def main(args: Array[String]): Unit = {
    val optionMonoid= new OptionMonoid[Int]()
    println(optionMonoid.op(Some(1), None))
    println(optionMonoid.op(Some(1), Some(2)))
    println(optionMonoid.op(None, Some(2)))
  }
}

