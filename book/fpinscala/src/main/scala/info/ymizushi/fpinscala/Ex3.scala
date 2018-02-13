object Ex3 {
  sealed trait List[+A]
  case object Nil extends List[Nothing]
  case class Cons[+A](head: A, tail: List[A]) extends List[A] {
  }

  object List {
    
    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, xs) => x + sum(xs)
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] = 
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))


    def tail[A](l: List[A]): List[A] =
      l match {
        case Cons(head, tail) => tail
        case Nil => Nil
      }

    def setHead[A](l: List[A], r: A): List[A] =
      l match {
        case Cons(head, tail) => Cons(r, tail)
        case Nil => Nil
      }

    def drop[A](l: List[A], n: Int): List[A] = {
      (n, l) match {
        case (_, Nil) => Nil
        case (0, _) => l
        case (1, Cons(head, tail)) => tail
        case (_, Cons(head, tail)) => drop(tail, n-1)
      }
    }


    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = {
      def innerDropWhile(l: List[A], f: A => Boolean, original: List[A]): List[A] = {
        l match {
          case Nil => original
          case Cons(head, tail) => if (f(head)) tail else innerDropWhile(tail, f, original)
        }
      }
      innerDropWhile(l, f, l)
    }
  }

  def main(args: Array[String]) = {
    // EXERCISE3.1
    val x = List(1, 2, 3, 4, 5) match {
      case Cons(x, Cons(2, Cons(4, _))) => x // 実行されない
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y // 3
      case Cons(h, t) => h + List.sum(t) // 上がマッチしているので実行されない
      case _ => 101 
    } // 3
    println(x)

    // EXERCISE 3.2
    println(List.tail(List(1, 2, 3, 4)))
    println(List.tail(Nil))

    // EXERCISE 3.3
    println(List.setHead(List(1, 2, 3, 4), 3))
    println(List.setHead(Nil, 5))

    // EXERCISE 3.4
    println(List.drop(Nil, 1))
    println(List.drop(List(1, 2, 3, 4), 1))
    println(List.drop(List(1, 2, 3, 4), 2))
    println(List.drop(List(1, 2, 3, 4), 3))
    println(List.drop(List(1, 2, 3, 4), 4))

    // EXERCISE 3.5
    println(List.dropWhile(List(1, 2, 3, 3), (n:Int) =>  n == 1))
    println(List.dropWhile(List(1, 2, 3, 3), (n:Int) =>  n == 2))
    println(List.dropWhile(List(1, 2, 3, 3, 4, 4, 3), (n:Int) =>  n == 4))
    println(List.dropWhile(List(1, 2, 3, 3, 4, 4, 3), (n:Int) =>  n == 10))
  }
}
