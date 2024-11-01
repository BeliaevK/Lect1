package Lec1.homeWorkCode

object HomeWork_Lect3 extends App {

  class Book(val name: String, val author: String, val yearOfPubl: Int) {
    override def toString: String = s"Книга: $name, автор: $author, год издания: $yearOfPubl"
  }

  object Book {
    def createBook(name: String, author: String, yearOfPubl: Int): Book = {
      new Book(name, author, yearOfPubl)
    }
  }

  val b1 = Book.createBook("Aзбука", "Издатель", 1965)
  println(b1)
  println("")

  abstract class Figure {
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

  val c1 = Circle(5)
  println(s"Площадь круга с радусом ${c1.radius} = ${c1.calcArea}")

  val r1 = Rectangle(10, 7)
  println(s"Площадь прямогольника со сторонами ${r1.length} и ${r1.width} = ${r1.calcArea}")

  val s1 = Square(9)
  println(s"Площадь квадрата со сторой ${s1.side} = ${s1.calcArea}")
}
