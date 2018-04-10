object MergeSort {
  def main(args: Array[String]): Unit = {
    println("hoge")
    println(mergeSort(List(10, 20, 100, 5, 2, 1, 5, 6, 7)))
  }

  def innerMergeSort(left: List[Int], right: List[Int]): List[Int] = {
    (left, right) match {
      case (Nil, Nil) => left
      case (left, Nil) => left
      case (Nil, right) => right
      case (left, right) => {
        val (leftLeft, leftRight) = left.splitAt(left.length/2)
        val (rightLeft, rightRight) = right.splitAt(right.length/2)
        innerMerge(innerMergeSort(leftLeft, leftRight), innerMergeSort(rightLeft, rightRight))
      }
    }
  }

  def innerMerge(left: List[Int], right: List[Int]): List[Int] = {
     if (left == Nil) {
       right
     } else if (right == Nil) {
       left
     } else if (left.head <= right.head) {
       left.head :: innerMerge(left.tail, right)
     } else {
       right.head :: innerMerge(left, right.tail)
     }
  }

  def mergeSort(l: List[Int]): List[Int] = {
     val (left, right) = l.splitAt(l.length/2)
     innerMergeSort(left, right)
  }
}
