object Ex3 {
  sealed trait List[+A] {
    def map[B](f: A => B): List[B]
    def flatMap[B](f: A => List[B]): List[B]
  }

  case object Nil extends List[Nothing] {
    def map[B](f: Nothing => B): List[B] = Nil
    def flatMap[B](f: Nothing => List[B]): List[B] = Nil
  }

  case class Cons[+A](head: A, tail: List[A]) extends List[A] {
    def map[B](f: A => B): List[B] = Cons(f(head), tail.map(f))
    def flatMap[B](f: A => List[B]): List[B] = List.flatten(Cons(f(head), tail.map(f)))
  }

  object List {

    // def foldRight2[A, B](as: List[A], z: B)(f: (A, B) => B):  B= {
    //   foldLeft(as.reverse , z)(f)
    // }

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

    def filter[A](as: List[A])(f: A => Boolean): List[A] =
      as match {
        case Cons(head, tail) => {
          if (f(head)) 
            Cons(head, filter(tail)(f))
          else
            filter(tail)(f)
        }
        case Nil => Nil
      }

    // def filter2[A](as: List[A])(f: A => Boolean): List[A] = 
    //   def localF(f: A => Boolean): A => List[B] =
    //     if(f(head))
    //       head => List(head)
    //     else
    //       head => Nil
    //   flatMap(as)(x => if(localF(f)) List(x) else Nil

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

    def reverse[A](as: List[A]): List[A] = {
      foldLeft(as, Nil: List[A])((acc: List[A], x: A) => Cons(x, acc))
    }

    def append[A](as: List[A], e: A): List[A] = {
      foldRight(as, Cons(e, Nil))(Cons(_, _))
    }
    
    def flatten[A](as: List[List[A]]): List[A] = {
       foldRight(as, Nil: List[A])((x: List[A], acc: List[A]) => 
         foldRight(x, acc)((x2: A, acc2: List[A]) => Cons(x2, acc2)))
    }

    def append2[A](as: List[A], e: A): List[A] = {
      foldLeft(List.reverse(as), Cons(e, Nil))((a, b) => Cons(b, a))
    }

    def zipAdd(las: List[Int], ras: List[Int]): List[Int] = {
      (las, ras) match {
        case (Cons(lasHead, lasTail), Cons(rasHead, rasTail)) => Cons(lasHead + rasHead,  zipAdd(lasTail, rasTail))
        case (Cons(lasHead, lasTail), Nil) => Nil
        case (Nil, Cons(rasHead, rasTail)) => Nil
        case _ => Nil
      }
    }

    def zipWith[A](l: List[A], r: List[A] ,adder: (A, A) => A): List[A] = {
      (l, r) match {
        case (Cons(lHead, lTail), Cons(rHead, rTail)) => Cons(adder(lHead, rHead), zipWith(lTail, rTail, adder))
        case _ => Nil
      }
    }

    def innerHasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
      (sup, sub) match {
        case (Cons(supHead, supTail), Cons(subHead, subTail)) => {
          if (supHead == subHead) 
            hasSubsequence(supTail, subTail)
          else
            hasSubsequence(supTail, sub)
        }
        case (_, Nil) => true
        case (Nil, _) => false
      }
    }

    def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
      sup match {
        case Cons(head, tail) => {
          if (innerHasSubsequence(sup, sub))
            true
          else
            innerHasSubsequence(tail, sub)
        }
        case Nil => false
      }
    }

    def mapInc(as: List[Int]): List[Int] = {
      as.map(_ + 1)
    }

    def mapDoubleToString(as: List[Double]): List[String] = {
      as.map(_.toString)
    }
  }

  sealed trait Tree[+A] 
  case class Leaf[A](value: A) extends Tree[A] 
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A] 

  object Tree {
    def size[A](t: Tree[A]): Int = {
      t match {
        case Leaf(v) => 1
        case Branch(l, r) => 1 + size(l) + size(r)
      }
    }

    def maximum(t: Tree[Int]): Int = {
      t match {
        case Leaf(v) => v
        case Branch(l, r) => { maximum(l) max maximum(r) }
      }
    }

    def depth[A](t: Tree[A]): Int = {
      t match {
        case Leaf(v) => 0
        case Branch(l, r) => 1 + (depth(l) max depth(r))
      }
    }

    def map[A,B](t: Tree[A], f: A => B): Tree[B] = {
      t match {
        case Leaf(v) => Leaf(f(v))
        case Branch(l, r) => Branch(map(l, f), map(r, f))
      }
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

    // Excercise 3.15
    println(List.flatten(List(List(1, 2, 3), List(4, 5, 6), List(7,8,9))))
    println(List.append(List(1, 2, 3, 3, 4, 4, 3), 5))
    println(List.append2(List(1, 2, 3, 3, 4, 4, 3), 5))

    // Excercise 3.16
    // Excercise 3.17
    // Excercise 3.18
    println(List.mapInc(List(1, 2, 3, 3, 4, 4, 3)))
    println(List.mapDoubleToString(List(1, 2, 3, 3, 4, 4, 3)))

    // Excercise 3.19
    assert(List.filter(List(1, 2, 3, 3, 4, 4, 3))(x => x % 2 == 0) == List(2, 4, 4), "3.21 failed")

    // Excercise 3.20
    assert(List(1, 2, 3).flatMap { (x: Int) => List(x, x)} == List(1, 1, 2, 2, 3, 3))

    // Excercise 3.21
    // assert(List(1, 2, 3).filter(_ % 2 == 0) == List(2))
    // assert(List(1, 2, 3).filter2(_ % 2 == 0) == List(2))
    
    // Excercise 3.22
    assert(List.zipAdd(List(1, 2, 3), List(2, 3, 4)) == List(3, 5, 7))
    assert(List.zipAdd(List(1, 2, 3), List(2, 3, 4)) == List(3, 5, 7))

    // Excercise 3.23
    assert(List.zipWith(List(1, 2, 3), List(2, 3, 4), (a:Int, b: Int) => {a + b}) == List(3, 5, 7))
    assert(List.zipWith(List(1, 2, 3), List(2, 3, 4, 5, 6), (a:Int, b: Int) => {a + b}) == List(3, 5, 7))

    // Excercise 3.24
    // TODO: 間違っているので治す
    assert(List.hasSubsequence(List(2, 3, 4, 5, 6), List(3, 4)) == true)
    assert(List.hasSubsequence(List(2, 3, 4, 5, 6), List(2, 4)) == true)

    // Excercise 3.25
    assert(Tree.size(Branch(Branch(Leaf(5), Leaf(1)), Leaf(2))) == 5)

    // Excercise 3.26
    assert(Tree.maximum(Branch(Branch(Leaf(6), Leaf(1)), Leaf(2))) == 6)

    // Excercise 3.27
    assert(Tree.depth(Branch(Branch(Leaf(6), Leaf(1)), Leaf(2))) == 2)


    // Excercise 3.28
    println(Tree.map(Branch(Branch(Leaf(6), Leaf(1)), Leaf(2)), (x: Int) => x.toString))
    Unit
  }
}
