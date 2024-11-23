package Lec1.homeWorkCode


object HomeWork_Lect9 extends App {

  def function1: Int => Int = (a: Int) => a + a

  def function2: Int => Int = (a: Int) => a * a

  def function3: Int => Int = (a: Int) => a / 2

  def listFun(f: Int => Int, f2: Int => Int, f3: Int => Int, i: Int): List[Int] = {
    val l = List(f(i), f2(i), f3(i))
    l
  }

  println(listFun(function1, function2, function3, 4))

}

object HofSumFoo extends App {

  val functions: List[Int => Int] = List((x: Int) => x + 1, (x: Int) => x * 2)

  def hofSumFoo(function: List[Int => Int]): Int => Int = {
    function.foldLeft((x: Int) => x) { (acc, func) =>
      (x: Int) => func(acc(x))
    }
  }
}


  object CurryThreeArgs extends App {
    def threeArgs(s: String, i: Int, d: Double): String = {
      s"$s $i $d"
    }

    val curryThreeArgs = threeArgs("Строка", _, _)

    println(curryThreeArgs(1, 3.0))
  }