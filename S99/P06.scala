object P06 {
  def main(args: Array[String]) = {
    println(isPalindrome(List(5, 1, 2, 3, 2, 1, 5)))
  }

  def isPalindrome[A](l: List[A]): Boolean = {
    l match {
      case Nil =>  true
      case head :: Nil => true
      case head :: last :: Nil => {
        if (head == last) 
          true
        else
          false
      }
      case head :: tail =>  {
        if (head == tail.last) 
          isPalindrome(tail.init)
        else
          false
      }
    }
  }
}
