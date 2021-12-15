@main def hello: Unit = 
  println("hoge")
  println(fib(10))

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