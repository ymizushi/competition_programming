object MergeSort {
  def main(args: Array[String]): Unit = {
    println(mergeSort(List(10, 20, 100, 5, 2, 1, 5, 6, 7)))
  }

  def innerMergeSort(left: List[Int], right: List[Int]): List[Int] = {
    (left, right) match {
      case (Nil, Nil) => Nil
      case (left, Nil) => left
      case (Nil, right) => right
      case (left, right) => {
        val (leftLeft, leftRight) = left.splitAt(left.length/2)
        val (rightLeft, rightRight) = right.splitAt(right.length/2)
        merge(innerMergeSort(leftLeft, leftRight), innerMergeSort(rightLeft, rightRight))
      }
    }
  }

  def merge(left: List[Int], right: List[Int]): List[Int] = {
    (left, right) match {
      case (Nil, Nil) => Nil
      case (left, Nil) => left
      case (Nil, right) => right
      case (l::lx, r::rx) if l <= r => l :: merge(lx, r::rx)
      case (l::lx, r::rx) => r :: merge(l::lx, rx)
    }
  }

  def mergeSort(l: List[Int]): List[Int] = {
     val (left, right) = l.splitAt(l.length/2)
     innerMergeSort(left, right)
  }
}
