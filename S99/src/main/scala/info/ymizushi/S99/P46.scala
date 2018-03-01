object P46 {

  def and(a: Boolean, b: Boolean): Boolean =
    a && b

  def or(a: Boolean, b: Boolean): Boolean =
    a || b

  def main(args: Array[String]) = {
    table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
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

  def main(args: Array[String]) = {
  }

  def and(a: Boolean, b: Boolean): Boolean = a && b

  def or(a: Boolean, b: Boolean): Boolean = a || b

  def xor(a: Boolean, b: Boolean): Boolean = a != b

  def table2(f: (Boolean, Boolean) => Boolean): Unit = {
  }
}
