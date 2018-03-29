object Ex3 {
  sealed trait List[+A] {
    def map[B](f: A => B): List[B]
  }
  case object Nil extends List[Nothing] {
    def map[B](f: Nothing => B): List[B] = {
      Nil
    }
  }
  case class Cons[+A](head: A, tail: List[A]) extends List[A] {
    def map[B](f: A => B): List[B] = {
      Cons(f(head), tail.map(f))
    }
  }

  object List {

    def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B):  B= {
      as match {
        case Nil => z
        case Cons(head, tail) => f(head, foldRight(tail, z)(f))
      }
    }
    
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

    def sumLeft(as:List[Int]): Int = {
      foldLeft(as, 0)(_ + _)
    }

    def productLeft(as:List[Int]): Int = {
      foldLeft(as, 1)(_ * _)
    }

    def lengthLeft[A](as:List[A]): Int = {
      foldLeft(as, 0)((acc: Int, x: A) => 1 + acc)
    }

    def length[A](as: List[A]): Int = {
      as match {
        case Nil => 0
        case Cons(head, tail) => 1 + length(tail)
      }
    }

    def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = {
      as match {
        case Nil => z
        case Cons(head, tail) => foldLeft(tail, f(z, head))(f)
      }
    }

    def reverse[A](as: List[A]): List[A] = {1
      foldLeft(as, Nil: List[A])((acc: List[A], x: A) => Cons(x, acc))
    }

    def append[A](as: List[A], e: A): List[A] = {
      foldRight(as, Cons(e, Nil))(Cons(_, _))
    }
    
    def flatten[A](as: List[A]*): List[A] = {
       as.foldRight(as, Nil)((x, acc) => {
         foldRight(x, acc)(Cons(x, acc))
       }
    }

    def mapInc(as: List[Int]): List[Int] = {
      as.map(_ + 1)
    }

    def mapDoubleToString(as: List[Double]): List[String] = {
      as.map(_.toString)
    }
  }

  def main(args: Array[String]):Unit = {
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

    // EXERCISE 3.7
    // 返せない
    
    // Exercise 3.8
    // 同じListが返る
    // TOOD: Listのデータコンストラクタとの関係性??
    
    // Exercise 3.9
    println(List.length(List(1, 2, 3, 3, 4, 4, 3)))

    // Excercise 3.10
    val f =  (acc: Int, x: Int) => {acc + x}
    println(List.foldLeft(List(1, 2, 3, 3, 4, 4, 3), 0)(_ + _))

    // Excercise 3.11
    println(List.sumLeft(List(1, 2, 3, 3, 4, 4, 3)))
    println(List.productLeft(List(1, 2, 3, 3, 4, 4, 3)))
    println(List.lengthLeft(List(1, 2, 3, 3, 4, 4, 3)))

    // Excercise 3.12
    println(List.reverse(List(1, 2, 3, 3, 4, 4, 3)))

    // Excercise 3.13
    // TODO

    // Excercise 3.14
    println(List.append(List(1, 2, 3, 3, 4, 4, 3), 5))

    // Excercise 3.14
    // TODO

    // Excercise 3.15
    println(List.append(List(1, 2, 3, 3, 4, 4, 3), 5))

    // Excercise 3.16
    // Excercise 3.17
    // Excercise 3.18
    println(List.mapInc(List(1, 2, 3, 3, 4, 4, 3)))
    println(List.mapDoubleToString(List(1, 2, 3, 3, 4, 4, 3)))

    Unit
  }
}
