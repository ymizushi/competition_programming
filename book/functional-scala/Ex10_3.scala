trait Monoid[A] {
  def op(a1: A, a2: A): A
  def zero: A
}

class EndoMonoid[A] extends Monoid[A => A] {
  def op(a1: A => A, a2: A => A): A => A
    = a1 compose a2

  def zero = (x: A) => x
}

object Main {
  def main(args: Array[String]): Unit = {
    val endoMonoid= new EndoMonoid[Int]()
    println(endoMonoid.op((x:Int) => x+x, (y: Int) => y+y))
  }
}

