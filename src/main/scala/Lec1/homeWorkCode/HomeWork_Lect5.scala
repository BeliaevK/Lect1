package Lec1.homeWorkCode

object HomeWork_Lect5 extends App {

  val oInt: Option[Int] = Option(1) // Опшн от инта равного 1. Вернет Some(1)
  val oInt2: Option[Int] = None
  val oString: Option[String] = Option("Hello World")
  println(oInt)
  // getOrElse - возвращает значение опшена, если оно Some, если None, то возвращает ветку Else, значение в скобках
  println(oInt.getOrElse("Пустой"))
  println(oInt2.getOrElse("Пустой"))

  println(oInt.isDefined) //Определен - Возвращает true, если опшен является экземпляром Some, и false в противном случае.

  println(oInt.nonEmpty) //Не пустой - Возвращает true, если опшен является экземпляром Some, и false в противном случае.
  //Избегает неявного преобразования в Iterable

  println(oInt2.isEmpty) //Пустой - Возвращает true, если опнш является экземпляром None, и false в противном случае.

  println(oInt.filter(i => i > 10)) // Фильтр - возвращает опшен, если он не пустой и удовлетворяет условию, None в противном случае.

  println(oInt.filterNot(i => i > 10)) // Фильтр нот - возвращает опшен, если он не пустой и НЕ удовлетворяет условию,
  // None в противном случае.

  println(oString.contains("Hello World")) // Содержит - Возвращает true, если опция содержит параметр заданное значение
  // в качестве элемента, и false в противном случае.

  println(oInt.exists(i => i > 1)) // Существует - Возвращает true, если опция не пустая и удовлетворяет условию в скобках,
  // и false в противном случае.

  println(oInt.forall(i => i < 10)) // Возвращает true, если опция ПУСТАЯ или удовлетворяет условию в скобках,
  // и false в противном случае.
  println(oInt2.forall(i => i < 10))


  println(oInt.get) // Возвращает значение опшена (может возращать NoSuchElementException), Опшен должен быть не пустым.
  // Рекомендуется отдавать предпочтение методу getOrElse

  println(oInt2.getOrElse("Пустой")) // Возвращает значение опшена, если он не пустой, иначе возвращает значение по умолчанию


}

object MethodTest extends App {
  val oString: Option[String] = Option("Hello")
  println(oString.map(_ + " World").getOrElse("None"))
  println(oString.get.toIndexedSeq(3))


}

object FindSubString extends App {
  val oString: Option[String] = Option("Hello World")
  val searchStr: String = "Hello"

  def findSubString(string: Option[String]): Unit = {
    if (string.getOrElse("None").contains(searchStr)) println("Слово найдено") else println("Слово не найдено")
  }

  findSubString(oString)
  println(oString.contains(searchStr))

}

object AgeClassifier extends App {
  val oInt: Option[Int] = Option(17)

  def ageClassifier(i: Option[Int]): Unit = {
    val t = i.getOrElse(0)
    if (t >= 18 & t <= 100) println("Взрослый")
    else if (t >= 10 & t < 18) println("Подросток")
    else if (t > 0 & t < 10) println("Ребенок")
    else println("Не корректные данные")
  }

  ageClassifier(oInt)
}



