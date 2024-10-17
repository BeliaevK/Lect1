package Lec1.lectureCode

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println(10 + 30)
  }
}

object HelloWorldWithApp extends App {
  println(2 - 30)
}

object TypesAndAllALL extends App {
  var x: Int  = 1 // java: var x = 1;
  val x1: Int = 2 // java: final var x = 1;
  //x = 3 // не нада так делать
  // x1 = 3 // ce

  val iMax: Int = Int.MaxValue
  val lMax: Long = Long.MaxValue
  val lMin: Long = Long.MinValue
  println(iMax)
  println(lMax+1)
  println(lMin)

  /**
   * doc
   */
  val d1: Double = Double.MaxValue
  println(d1)

  //Однострочный комментарий
  val str = "abc"

  /*
    Многострочный
    комментарий
   */
  val c = '\u2188'
  println(c)

  val div = x % x1
  println(div)

  val u: Unit = println("") // Unit eq void

  val b: Boolean = x1 == x

  // можно использовать когда непонятно или не время реализовать сейчас, например
  //   val n: Nothing = ???
  //  val n1: Nothing = throw new Exception("")

  import java.lang.{Long => jLong}
  // PersonVerifyPassportUtils => pvpu
  val jl: Long = Long2long(jLong.getLong("1"))

  //  type PersonId = jLong
  //  val pId: PersonId = 1L
  type PersonId       = Long
  type ContactType    = String
  type ContactValue   = String
  type PersonContacts = Map[ContactValue, ContactType]

  //pmShmthg: Map[Long, Map[String, String]]
  val pmShmthg: Map[PersonId, PersonContacts] = Map(1L -> Map("email" -> "c@ya.hs"))
}

object StringSmthng extends App {
  var x: Int  = 1
  val x1: Int = 2

  // java : "str " + x
  val str1 = s"$x + $x1 = ${x + x1}" // java 21 => STR.""
  println(str1)
  println("---------------------")
  val str2 =
    """
      |aaa
      |bbb
      |""" //.stripMargin
  println(str2)
  println("---------------------")
  val str3 =
    """
      |ccc
      |ddd
      |""".stripMargin
  println(str3)
}

object TupleSmthng extends App {
  // Кортеж - контейнер содержащий упорядоченный набор элементов различного типа
  val t1: (Int, Int, String, Boolean) = (1, 2, "6", true)
  println(t1._3)
  val t2: (Int, String)            = 1 -> "1" // Такой кортеж можно представить как Map(k,v)
  val tuple2: (Int, String, String)            = (1,"1", "2")
  val t3: ((Int, String), Boolean) = 1 -> "1" -> true
  val tuple3: ((Int, String, String), Boolean) = (1, "1", "3") -> true
  println(t3)
  println(tuple3)
  //println(t3._1._2)

  val (i, s) = t2
  //  val m: Map[Int, Int] = Map(1 -> 2, 2 -> 3, 3 -> 4)
  //  java: map(x -> {x+x; x-x})
  //  m.map { case (k, v) =>
  //    val (k, v) = kv
  //    kv
  //    1
  //  }
}

object DefFun extends App {
  // void myPrint(String str) { sout(str) }
  def myPrint(str: String): Unit = println(str)
  myPrint("myPrint - s")

  def myPrint1(str: String, i: Int): Int = {
    println("Печать Int с myPrint1: " + i)
    println("Печать String с myPrint1: " + str)
    //str
    i
  }
  myPrint1("s", 2)
  println(myPrint1("тест", 100))

  val x1: Int => Int = myPrint1("s22", _) //Подставление первого параметра по умолчанию и ождаение передачи второго параметра
  x1(22)
 def myPrint2(str: String)(i: Int): Int = {
    println("Печать Int с myPrint2: " + i)
    println("Печать String с myPrint2: " + str)
    //str
    i
  }
  val x: Int => Int = myPrint2("s33")(_)
  x(33)

  //Различные записи одной функции с использованием разного кол-ва синтаксического сахара Scala
  val x2: Int => Int = (i: Int) => i * 2
  val x3: Int => Int = i => i * 2
  val x4: Int => Int = _ * 2

  //Различные записи
  println(x2(5))
  println(x2.apply(5))
}

object DefaultDefParam extends App {
  // Пример запси с передачей параметра по учимолчанию, при необходимости
  def myPrint1(str: String, i: Int = 1, d: Double): Int = {
    println(i)
    println(str)
    //str
    i
  }
  myPrint1(
    d = 1d,
    //i = 3,
    str = "1"
  )


}