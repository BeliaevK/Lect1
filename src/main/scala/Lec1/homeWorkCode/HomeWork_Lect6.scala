package Lec1.homeWorkCode

import scala.util.{Failure, Random, Success, Try}

object HomeWork_Lect6 extends App {

  val random = Random.nextInt(40)

  val find1to10: Either[String, String] = {
    if (random < 1 || random > 10) Left(s"Не нашли от 1 до 10, итоговый результат: $random")
    else Right(random).map(i => s" Нашли!, результат: $random")
  }
  println(find1to10)


  val a = 15
  val b = 5


  val devisionOpt = Option(a).flatMap(i1 => Option(b).filter(_ > 0).map(i2 => i1 / i2))
  println(devisionOpt.getOrElse(Console.RED + "Деление на ноль!" + Console.RESET))

  def mayBeDivisionTry(a: Int, b: Int): Try[Int] = Try {
    a / b
  }

  val x = mayBeDivisionTry(a, b)
  x match {
    case Failure(exception) => println(Console.RED + "Ошибка: " + exception.getMessage + Console.RESET)
    case Success(value) => println(value)
  }


  def mayBeDivisionEither(a: Int, b: Int): Either[String, Int] = {
    if (b == 0) Left(Console.RED + "Деление на ноль!" + Console.RESET)
    else Right(a / b)
  }

  val x2 = mayBeDivisionEither(a, b)
  x2 match {
    case Left(value) => println(value)
    case Right(value) => println(value)
  }

}
