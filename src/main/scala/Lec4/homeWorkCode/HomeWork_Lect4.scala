package Lec4.homeWorkCode
import java.time.{LocalDate, LocalTime}


object HomeWork_Lect4 extends App {
  trait Figure {
    def calcArea: Double
  }

  case class Circle(radius: Int) extends Figure {

    import scala.math.Pi

    override def calcArea: Double = {
      Pi * (radius * radius)
    }
  }

  case class Rectangle(length: Int, width: Int) extends Figure {
    override def calcArea: Double = {
      length * width
    }
  }

  case class Square(side: Int) extends Figure {
    override def calcArea: Double = {
      side * side
    }

  }

  def fullMatch(figure: Figure): Unit = figure match {
    case Circle(radius: Int) => println(s"Круг с радиусом равным $radius")
    case Rectangle(length: Int, width: Int) => println(s"Прямоугольник с длинной равной $length и шириной равной $width")
    case Square(side: Int) if side > 100 => println(Console.BLUE + s"ОГРОМНЫЙ квадрат со стороной равной $side" + Console.RESET)
    case Square(side: Int) => println(s"Квадрат со стороной равной $side")
  }

  def typeMatch(figure: Figure): Unit = figure match {
    case c: Circle => println("Данная фигура является кругом")
    case r: Rectangle => println("Данная фигура является прямоугольником")
    case s: Square => println("Данная фигура является квадратом")
  }

  val c1 = Circle(5)
  fullMatch(c1)
  typeMatch(c1)
  println(s"Площадь круга с радусом ${c1.radius} = ${c1.calcArea}")

  val r1 = Rectangle(10, 7)
  fullMatch(r1)
  typeMatch(r1)
  println(s"Площадь прямогольника со сторонами ${r1.length} и ${r1.width} = ${r1.calcArea}")

  val s1 = Square(9)
  val s2 = Square(120)
  fullMatch(s1)
  fullMatch(s2)
  typeMatch(s1)
  println(s"Площадь квадрата со сторой ${s1.side} = ${s1.calcArea}")


}

sealed trait TypeMassage

case class INFO(massage: String) extends TypeMassage

case class WARN(massage: String) extends TypeMassage

case class ERROR(massage: String) extends TypeMassage

object Logger extends App {

  def logIt(massage: TypeMassage): Unit =
    massage match {
      case INFO(massage) => println(Console.GREEN + s"${LocalDate.now} ${LocalTime.now()} [$INFO] $massage" + Console.RESET)
      case WARN(massage) => println(Console.YELLOW + s"${LocalDate.now} ${LocalTime.now()} [$WARN] $massage" + Console.RESET)
      case ERROR(massage) => println(Console.RED + s"${LocalDate.now} ${LocalTime.now()} [$ERROR] $massage" + Console.RESET)
    }

  logIt(INFO("Информационное сообщение"))
  logIt(WARN("Предупреждение"))
  logIt(ERROR("Сообщение об ошибке"))
  logIt(INFO("Информационное сообщение №2"))
  logIt(WARN("Предупреждение №2"))
  logIt(ERROR("Сообщение об ошибке №2"))

}
