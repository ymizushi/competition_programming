import scala.io._

object P3 {
  def main(args:Array[String]):Unit =
    println(isPrime(10))

  def isPrime(n:Int):Boolean =
    n match {
      case 1 => false
      case 2 => true
      case _ => false
    }
}
