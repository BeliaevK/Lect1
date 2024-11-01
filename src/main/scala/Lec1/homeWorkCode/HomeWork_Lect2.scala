package Lec1.homeWorkCode

object EvenOddNum_Lect2 extends App {
  def evenOddNum = (i: Int) => if (i % 2 == 0) "Чётное" else "Нечётное"

  val num1 = 1
  val num2 = 2
  val num3 = 3
  println("---------------------------------------------")
  println("Функция для проверки числа на четность/нечетность")
  println(s"Число $num1: ${evenOddNum(num1)}")
  println(s"Число $num2: ${evenOddNum(num2)}")
  println(s"Число $num3: ${evenOddNum(num3)}")
  println("|---------------------------------------------")
}

object PosNegOrZeroNum_Lect2 extends App {
  def posNegOrZeroNum = (i: Int) => if (i > 0) "Положительное" else if (i < 0) "Отрицательное" else "Является нулем"

  val num1 = -99
  val num2 = 100
  val num3 = 0
  println("---------------------------------------------")
  println("Функция проверяет, является ли число  положительным, отрицательным или нулём")
  println(s"Число $num1: ${posNegOrZeroNum(num1)}")
  println(s"Число $num2: ${posNegOrZeroNum(num2)}")
  println(s"Число $num3: ${posNegOrZeroNum(num3)}")
  println("|---------------------------------------------")
}

object ForToOrUntil10 extends App {
  //def forTo10 = for (i <- 1 to 10) print(i +  ", ")
  def forTo10: Unit = {
    val numb1 = for (i <- 1 to 10) yield i
    println(numb1.mkString(", "))
  }

  //def forUntil10 = for (i <- 1 until  10) print(i +  ", ")
  def forUntil10: Unit = {
    val num2 = for (i <- 1 until 10) yield i
    println(num2.mkString(", "))
  }

  forTo10
  println("")
  forUntil10
}

object ForMultipTable5 extends App {
  // Int* - Аргументы переменной длины
  def multiplicationTables(factors: Int*): Unit = {
    for (factor <- factors) {
      for (i <- 1 to 10) {
        println(s"$i x $factor = ${factor * i}")
      }
    }
  }

  println("---------------------------------------------")
  println("Функция, которая с помощью цикла for выводит в консоль таблицу умножения на 5 до 10")
  multiplicationTables(5)
  println("|---------------------------------------------")
}

object Fibon extends App {
  def fibon(n: BigInt): BigInt = {
    if (n == 0) 0
    else if (n == 1) 1
    else fibon(n - 1) + fibon(n - 2)
  }

  println("---------------------------------------------")
  println("функция для вычисления чисел Фибоначчи(рекурсия), вывести в консоль первые 10 чисел")
  println(fibon(BigInt(10)))
  println("|---------------------------------------------")
}

object FibonTail extends App {
  def fibon(n: BigInt): BigInt = {
    import scala.annotation.tailrec
    @tailrec
    def fibonTail(n: BigInt, a: BigInt, b: BigInt): BigInt = {
      if (n == 0) a
      else fibonTail(n - 1, b, a + b)
    }

    fibonTail(n, 0, 1)
  }

  println("---------------------------------------------")
  println("функция для вычисления чисел Фибоначчи(хвостовая рекурсия), вывести в консоль первые 10 чисел")
  println(fibon(BigInt(10)))
  println(fibon(BigInt(1000)))
  println("|---------------------------------------------")
}