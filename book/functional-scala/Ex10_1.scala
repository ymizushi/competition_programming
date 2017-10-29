trait Monoid[A] {
  def op(a1: A, a2: A): A
  def zero: A
}

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

object Main {
  def main(args: Array[String]): Unit = {
    val intAddition = new IntAdditionMonoid
    val intMultipication = new IntMultiplicationMonoid
    println(intAddition.op(4, 8))
  }
}
