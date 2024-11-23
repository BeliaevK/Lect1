package Lec1.homeWorkCode

object HomeWork_Lect10 extends App {

  def sqrtRoot: PartialFunction[Double, Double] = {
    case x if x >= 0 => Math.sqrt(x)
  }

  def sqrtRoot2: PartialFunction[Int, Int] = {
    case x if (x >= 0) && (sqrtRoot(x) == sqrtRoot(x).toInt) => x
  }

  val list = List(-1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 16)

  println(list.collect(sqrtRoot2))

}
