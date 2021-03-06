object Ex2 {
  def main(args: Array[String]) = {
    println(fib(19))
    println(fib_b(19))

    println(isSorted(Array(1, 2, 3, 4, 6) , (a: Int ,b: Int) => a < b ))
    println(isSorted(Array(2, 1, 3, 4, 6) , (a: Int ,b: Int) => a < b ))

    val f = (x:Int, y:String) => x.toString + y 
    val curriedF = curry(f)
    println(f)
    println(f(1, "hoge"))
    println(curriedF(1)("hoge"))

    val curryF = (x:Int) => (y:String) => x.toString + y 
    val uncurriedF = uncurry(curryF)
    println(curryF)
    println(curryF(1)("hoge"))
    println(uncurriedF(1, "hoge"))

  }

  // Exercise 2.1
  def fib(tn: Int): Int = {
    @annotation.tailrec
    def fib_n(n_2: Int, n_1:Int, n: Int):Int = {
      if (n == tn) {
        n_2 + n_1
      } else {
        fib_n(n_1, n_2+n_1, n+1)
      }
    }
    if (tn == 0)
      0
    else if (tn == 1) 
      1
    else
      fib_n(0,1,2)
  }
  
  def fib_b(n: Int): Int = {
    if (n <= 0) {
      0
    } else if (n == 1) {
      1
    } else {
      fib(n-2) + fib(n-1)
    }
  }


  // Exercise 2.2
  @annotation.tailrec
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    val head = as.head
    val rest = as.tail
    if (rest.isEmpty) 
      true
    else if (ordered(head, rest.head))
      isSorted(rest, ordered)
    else
      false
  }
  
  // Exercise 2.3
  def curry[A, B, C](f: (A, B) => C): A => B => C = 
    (a:A) => (b:B) => f(a, b)

  // Exercise 2.4
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = 
    (a: A, b: B) => f(a)(b)

  // Exercise 2.5
  def compose[A, B, C](f: B => C, g: A => B): A => C = (a:A) => f(g(a))
}


sealed trait MyOption[+A] {
  def isDefined: Boolean
  def map[B](f: A => B): MyOption[B]
  def flatMap[B](f: A => MyOption[B]): MyOption[B]
  def get: A
}

case class MySome[+A](value: A) extends MyOption[A] {
  def isDefined: Boolean = true

  def map[B](f: A => B): MyOption[B] = {
    MySome(f(value))
  }

  def get: A =  value

  def flatMap[B](f: A => MyOption[B]): MyOption[B] = {
    val v = f(value)
    if (v.isDefined) 
      MySome(v.get)
    else MyNone
  }
}

case object MyNone extends MyOption[Nothing] {
  def isDefined: Boolean = false
  def map[B](f: Nothing => B): MyOption[B] = MyNone
  def get: Nothing =  throw new Exception("error")
  def flatMap[B](f: Nothing => MyOption[B]): MyOption[B] = {
    MyNone
  }
}

sealed trait LinkedList[+A] {
}

case object Nil extends LinkedList[Nothing]
case class Cell[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
