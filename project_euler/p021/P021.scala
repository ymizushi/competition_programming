import scala.collection.immutable.List


object P021 {
  def d(n: Int) = (1 to n-1).filter(n % _ == 0).sum

  def main(args: List[String]) {
    println(d(10))
  }
}
