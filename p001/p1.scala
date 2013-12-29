import scala.io._

object P1 {
  def main(args: Array[String]) =
    println(this.sumMulti(999))

  def sumMulti(n: Int, sum: Int = 0):Int = 
    if (n == 0) 
      sum
    else 
       if (n % 3 == 0 || n % 5 == 0) 
         sumMulti(n-1, sum+n)
       else 
         sumMulti(n-1, sum)
}
