object P46 {

  implicit class AddBooleanToLogical(v: Boolean) {
    def and(b: Boolean): Boolean = 
      v && b

    def or(b: Boolean): Boolean = 
      v || b

  }

  def not(b: Boolean): Boolean = !b

  def main(args: Array[String]) = {
    table2((a: Boolean, b: Boolean) => a and (a or not(b)))
  }

  def table2(f: Function2[Boolean, Boolean, Boolean]): Unit = { 
    val patterns = Seq(
      (true, true),
      (true, false),
      (false, true),
      (false, false)
    )

    println("A    B   Result")
    patterns.map { pattern =>
      println(s"${pattern._1} ${pattern._2} ${f(pattern._1, pattern._2)}")
    }
  }
}

