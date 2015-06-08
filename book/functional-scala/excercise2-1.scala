def fib(x: Int): Int = {
  @annotation.tailrec
  def fib_n(n_2: Int, n_1:Int, n: Int):Int = {
    if (n == x) {
      n_2 + n_1
    } else {
      fib_n(n_1, n_2+n_1, n+1)
    }
  }
  fib_n(0,1,1)
}

// @annotation.tailrec
def fib_b(n: Int): Int = {
  if (n <= 0) {
    0
  } else if (n == 1) {
    1
  } else {
    fib(n-2) + fib(n-1)
  }
}

println(fib(4))
println(fib_b(4))
