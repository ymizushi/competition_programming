package info.ymizushi.S99

object P36 {
  implicit class AddInt(n: Int) {
    import P35.AddIntTo

    def primeFactorMultiplicity: List[(Int, Int)] = {
      def primeTuple(current: Int, archived: List[(Int, Int)], rest: List[Int], count: Int): List[(Int, Int)] = {
        if (rest.isEmpty) {
          val last = (current, count)
          archived:+last
        } else if (current == rest.head) {
          primeTuple(rest.head, archived, rest.tail, count+1)
        } else {
          val t = (current, count)
          primeTuple(rest.head, archived:+t, rest.tail, 1)
        }
      }
      val f = n.primeFactors
      primeTuple(f.head, List.empty[(Int,Int)], f.tail, 1)
    }
  }
}
