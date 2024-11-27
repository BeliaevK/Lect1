package Lec1.homeWorkCode

import scala.beans.BeanProperty


object HomeWork_Lect11 extends App {

  import UtilsImplicitClass._

  val x: Int = 1
  println(x.multipl5)
  println(x.multipl10)
  println(x.isEven)
  println((x + 1).isEven)
  println(100.usdToRub)
  println(100.rubToUsd)

  val listPerson = List[Person](Person("Вася", 10), Person("Петя", 9), Person("Федор", 9), Person("Артем", 80), Person("Ян", 30), Person("Артем", 8))

  implicit val sortedByAge: Ordering[Person] = Ordering.by(person => -person.age)

  // Примеры сортировок по имени и полной сортировке
  //implicit val sortedByName: Ordering[Person] = Ordering.by(person => (person.name))
  //implicit val sortedAll: Ordering[Person] = Ordering.by(person => (person.name, person.age))

  println(listPerson.sorted)

  // Синтасис, если у нас задано несколько неявных сортировок
  //println(listPerson.sorted(sortedByAge))
  //println(listPerson.sorted(sortedByName))
  //println(listPerson.sorted(sortedAll))

}

object UtilsImplicitClass {
  implicit class Multipl5(i: Int) {
    def multipl5: Int = i * 5
  }

  implicit class Multipl10(i: Int) {
    def multipl10: Int = i * 10
  }

  implicit class IsEven(i: Int) {
    def isEven: Boolean = i % 2 == 0
  }

  implicit class ConvertCurrency(int: Int) {
    val courseUSDtoRUB = 104
    val courseRUBtoUSD = 0.0096

    def usdToRub: Int = int * courseUSDtoRUB

    def rubToUsd: Double = int * courseRUBtoUSD
  }
}

case class Person(@BeanProperty name: String, @BeanProperty age: Int)
