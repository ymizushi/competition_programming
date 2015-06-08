def fib(x: Int): Int = {
  def fib_n(n_2: Int, n_1:Int, n: Int):Int = {
    if (n == x) {
      n_2 + n_1
    } else {
      fib_n(n_1, n_2+n_1, n+1)
    }
  }
  fib_n(0,1,1)
}


println(fib(4))
