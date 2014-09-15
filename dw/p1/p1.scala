object HelloWorld {
  val a = List(1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3, 8, 13)
  val k = 444

  def main(args: Array[String]):Unit = {
    println("Hoge")
    this.hoge()
  }

  def hoge():Unit = {
    println("Hoge")
  }

  def part_sum?(a:Array[Int], k:Int):Int = {
    val n = a.length
    def part_sum?(index:Int, sum:Int):Int = {
      if (index == n) {
        sum == k
      } else if (this.part_sum?(inde+1, sum)) {
        true
      } else if (this.part_sum?(inde+1, sum+a[index])) {
      
      }
    
    }
  }
}
