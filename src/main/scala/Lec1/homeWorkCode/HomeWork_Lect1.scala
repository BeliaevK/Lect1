package Lec1.homeWorkCode
import scala.math._

object Pow2_Lect1 extends App {
  def pow2 = (i: Int) => i * i

  val x = 2
  val x2 = 10
  val x3 = 50
  println(
    """
      |---------------------------------------------
      |Результаты функции возведения числа в квадрат:""".stripMargin)
  println(s"$x в квадрате = ${pow2(x)}")
  println(s"$x2 в квадрате = ${pow2(x2)}")
  println(s"$x3 в квадрате = ${pow2(x3)}")
  println("""|---------------------------------------------""".stripMargin)
}

object AreaOfCircle_Lect1 extends App {
  def areaOfCircle = (i2: Int) => Pi * i2 * i2
  val radius = 1
  println(
    """
      |---------------------------------------------
      |Функция, которая принимает на вход радиус окружности и возвращает её площадь:""".stripMargin)
  println(s"При радиусе окружности  равной $radius, её площать равна ${areaOfCircle(radius)}")
  println("""|---------------------------------------------""".stripMargin)
}

object TempCtoF_Lect1 extends App {
  def tempCtoF: Double => Double = (c: Double) => c * 9 / 5 + 32
  val temp = 36.6
  println(
    """
      |---------------------------------------------
      |Функция, которая принимает на вход  на вход температуру в градусах Цельсия и выводит её эквивалент в градусах Фаренгейта:""".stripMargin)
  println(s"При температуре в градусах Цельсия  равной $temp, её эквивалент в градусах Фаренгейта равен ${tempCtoF(temp)}")
  println("""|---------------------------------------------""".stripMargin)
}

object strLength_Lect1 extends App {
  def strLength: String => Int = (s: String) => s.length
  val str = "Hello World!"
  println(
    """
      |---------------------------------------------
      |Функция, которая принимает на вход строку и возвращать её длину, вывести в консоль:""".stripMargin)
  println(s"Длина строки '$str' равна ${strLength(str)}")
  println("""|---------------------------------------------""".stripMargin)
}

object distance_Lect1 extends App {
  def distance  (point: (BigDecimal,BigDecimal), point2: (BigDecimal, BigDecimal)):BigDecimal = {
    val  dx = point2._1 - point._1
    val  dy = point2._2 - point._2
    BigDecimal(sqrt(dx.doubleValue * dx.doubleValue + dy.doubleValue * dy.doubleValue))
  }
  val point = (BigDecimal(2.5), BigDecimal (3.7))
  val point2 = (BigDecimal(4.2), BigDecimal(1.8))

  println(    """
                |---------------------------------------------
                |Функция, которая вычисляет расстояние между двумя точками:""".stripMargin)
  println(s"Расстояние между точками (${point._1}, ${point._2}) и (${point2._1}, ${point2._2}) равно: ${distance(point,point2)}")
  println(    """|---------------------------------------------""".stripMargin)

}
