object Ex2_3 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = 
    a => b => f(a, b)

  def main(args: Array[String])  = {}
    val f = (x:Int, y:String) => x.toString + y 
    val hoge = curry(f)
    println(f)
    println(f(1, "hoge"))
    println(hoge(1)("hoge"))
}
