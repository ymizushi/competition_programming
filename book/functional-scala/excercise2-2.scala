@annotation.tailrec
def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
  val head = as.head
  val rest = as.tail
  if (rest.isEmpty) 
    true
  else if (ordered(head, rest.head))
    isSorted(rest, ordered)
  else
    false
}


println(isSorted(Array(1, 2, 3, 4, 6) , (a: Int ,b: Int) => a < b ))
println(isSorted(Array(2, 1, 3, 4, 6) , (a: Int ,b: Int) => a < b ))
