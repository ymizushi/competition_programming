object TypeClass {
  def main(args: Array[String]): Unit = {
    println("hoge")
  }
}

trait Functor[A] {
  val value: A
  def map[B](f: A => B): Functor[B]
}


class OptionFunctor[A] extends Functor[Option[A]] {
  def map[B](f: A => B): Option[B] = {
    Some(f())

  }
}
