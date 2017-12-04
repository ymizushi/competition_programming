package info.ymizushi.S99

import scala.collection.immutable.Range.Inclusive

object P39 {
  def isPrime(n: Int): Boolean = {
    (1 to n).filter(n % _ == 0).length == 2
  }

  def listPrimesInRange(inclusive: Inclusive): List[Int] = {
    def innerListPrimesInRange(l: List[Int]): List[Int] = {
      l match {
        case Nil => Nil
        case head ::rest => if (isPrime(head)) head :: innerListPrimesInRange(rest) else innerListPrimesInRange(rest)
      }
    }
    innerListPrimesInRange(inclusive.toList)
  }
}
