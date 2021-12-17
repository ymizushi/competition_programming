@main def hello: Unit = 
  println("hoge")
  println(fib(10))
  println(isSorted(Array(2, 4, 3, 5), (l, r) => l < r))

def fib(n: Int): Int = {
  if (n==0) {
    1
  } else if (n==1) {
    1
  } else {
    fib(n-2) + fib(n-1)
  }
}

def fib_toc(n: Int): Int = {
  def internal_fib(nt: Int, n_1: Int, n_2: Int): Int = {
    if (n==0) {
      1
    } else if (n==1) {
      1
    } else {
      internal_fib(nt-1, n_2, n_1+n_2)
    }
  }
  internal_fib(n, 0, 1)
}

def reduceFunc[A](l: A, r: A, f: (A, A) => Boolean): A = {
  if (f(l, r)) {
    r
  } else {
    l
  }
}

def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
  def loop(head: A, tail: Array[A]): Boolean = {
    if (tail.length==0) {
      true
    } else if (ordered(head, tail.head)) {
      loop(tail.head, tail.tail)
    } else {
      false
    }
  }
  loop(as.head, as.tail)
}