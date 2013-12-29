import scala.io._

object P2 {
  def main(args:Array[String]):Unit =
    println(sumEvenFib(4000000))

  def isEven(n:Int):Boolean =
    if (n%2 == 0) true else false

  def fibl(n:Int, n_2:Int, n_1:Int, sum:Int, maxNum:Int):Int = { 
    val nowNum = n_2+n_1
    if (nowNum >= maxNum)
      sum
    else 
      if (isEven(nowNum))
        fibl(n+1, n_1, nowNum, sum+nowNum, maxNum)
      else
        fibl(n+1, n_1, nowNum, sum, maxNum)
  }

  def sumEvenFib(maxNum:Int):Int =
    fibl(0, 0, 1, 0, maxNum)
}
