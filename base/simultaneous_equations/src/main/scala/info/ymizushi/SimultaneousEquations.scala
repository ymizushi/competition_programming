package info.ymizushi.se

object SimultaneousEquations {
  def main(args: Array[String]): Unit = {
    val mat = new Matrix(3, 3, Seq(2, 4, 16, 3, 5, 21))
    println(mat.row(0))
    val result = mat.row(0).map(e => e.toFloat / mat.get(0,0).toFloat).map(_.toInt)
    println(result)
    println(mat.get(1, 0))
    println(mat.get(1, 1))
  }
}

class Matrix(width: Int, height: Int, matrix: Seq[Int]) {
  def row(y: Int): Seq[Int] = {
    val startIndex = y * width
    val endIndex = y * width + width
    matrix.slice(startIndex, endIndex)
  }

  def get(x: Int, y: Int) = {
    matrix(y * width + x)
  }
}
