package Lec1.homeWorkCode


import Lec1.homeWorkCode.HomeWork_Lect7.DayOfTheWeek.{Day, MON, TUE, WED, THU, FRI, SAT, SUN}


object HomeWork_Lect7 extends App {

  object DayOfTheWeek extends Enumeration {
    type Day = Value
    val MON, TUE, WED, THU, FRI, SAT, SUN = Value
  }

  def subEnum(s: Day, e: Day): List[Day] = {
    val lDay: List[Day] = DayOfTheWeek.values.slice(s.id + 1, e.id).toList
    lDay
  }

  println(subEnum(TUE, SAT))

  def nextDayFrom(d: Day): Day = d match {
    case MON => TUE
    case TUE => WED
    case WED => THU
    case THU => FRI
    case FRI => SAT
    case SAT => SUN
    case SUN => MON
  }

  println(s"nextDayFrom - ${nextDayFrom(MON)}")

  def nextDayFrom2(d: Day): HomeWork_Lect7.DayOfTheWeek.Value = {
    //DayOfTheWeek.values.foreach(i => println(s"${i} ${i.id}"))
    //println(DayOfTheWeek.maxId)
    //Почему?????????????????
    if (d.id + 1 == DayOfTheWeek.maxId) DayOfTheWeek.values.find(i2 => i2.id == 0).get else DayOfTheWeek.values.find(i2 => i2.id == d.id + 1).get
  }

  println(s"nextDayFrom2 - ${nextDayFrom2(SUN)}")
}

object DayOfTheWeekTrait extends App {
  sealed trait DayOfTheWeekTrait {
    val id: Int
    val name: String
  }

  case class Mon() extends DayOfTheWeekTrait {
    override val id: Int = 1
    override val name: String = "Понедельник"
  }

  case class Tue() extends DayOfTheWeekTrait {
    override val id: Int = 2
    override val name: String = "Вторник"
  }

  case class Wed() extends DayOfTheWeekTrait {
    override val id: Int = 3
    override val name: String = "Среда"
  }

  case class Thu() extends DayOfTheWeekTrait {
    override val id: Int = 4
    override val name: String = "Четверг"
  }

  case class Fri() extends DayOfTheWeekTrait {
    override val id: Int = 5
    override val name: String = "Пятница"
  }

  case class Sat() extends DayOfTheWeekTrait {
    override val id: Int = 6
    override val name: String = "Суббота"
  }

  case class Sun() extends DayOfTheWeekTrait {
    override val id: Int = 7
    override val name: String = "Воскресенье"
  }

  def nextDayFrom(d: String): String = d match {
    case "Понедельник" => DayOfTheWeekTrait.Tue.apply().name
    case "Вторник" => DayOfTheWeekTrait.Wed.apply().name
    case "Среда" => DayOfTheWeekTrait.Thu.apply().name
    case "Четверг" => DayOfTheWeekTrait.Fri.apply().name
    case "Пятница" => DayOfTheWeekTrait.Sat.apply().name
    case "Суббота" => DayOfTheWeekTrait.Sun.apply().name
    case "Воскресенье" => DayOfTheWeekTrait.Mon.apply().name
  }

  println(nextDayFrom("Воскресенье"))

}

object UniqValue extends App {
  val luniqInt = List(1, 2, 3, 4, 4, 5, 6, 6)
  val luniqIntStr = List("Слово", "Слово2", "Слово", "Слово3")

  def uniqValue[T](list: List[T]): List[T] = {
    list.distinct
  }


  println(uniqValue(luniqInt))
  println(uniqValue(luniqIntStr))
}

object AverageValue extends App {
  val l1 = List(Option(1), Option(1), None, Option(10), Option(11))

  def averageValue(list: List[Option[Int]]): Double = {

    list.flatten.sum.toDouble / list.size
  }

  println(averageValue(l1))

}

object SumOrNone extends App {
  val l2 = List(Option(1), Option(1), None, Option(10), Option(11))

  def sumOrNone(list: List[Option[Int]]): Option[Int] = {
    if (list.contains(None)) None else Option(list.flatten.sum)
  }

  println(sumOrNone(l2))
}

object LengthMoreThen5 extends App {
  val l3 = List(Option("12"), Option("12345"), Option("123456"), None, Option("1234567"))

  def lengthMoreThen5(list: List[Option[String]]): List[Option[String]] = {
    list.filter(i => i.getOrElse("").length > 5)
  }

  println(lengthMoreThen5(l3))
}

object ExistIn2ListValue extends App {
  val l4 = List("Москва", "Токио", "Сингапур", "Пекин", "Стамбул", "Вашингтон")
  val l5 = List("Амстердам", "Ташкент", "Пекин", "Стамбул", "Токио", "Париж", "Москва")

  def existIn2ListValue(l1: List[String], l2: List[String]): List[String] = {
    l1.intersect(l2)
  }

  println(existIn2ListValue(l4, l5))
}

object Combo2ListValue extends App {
  val l6 = List(1, 2, 3)
  val l7 = List(4, 5, 6, 7, 1)

  def combo2ListValue(l1: List[Int], l2: List[Int]): List[(Int, Int)] = {
    val combo1 = for {
      i <- l1
      j <- l2
    } yield (i, j)
    val combo2 = for {
      j <- l2
      i <- l1
    } yield (j, i)
    val full = combo1.concat(combo2).distinct.sorted
    full
  }

  println(combo2ListValue(l6, l7))
}