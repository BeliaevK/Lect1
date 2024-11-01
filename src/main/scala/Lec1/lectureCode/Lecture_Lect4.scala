package Lec1.lectureCode

import Lec1.lectureCode.ScalaTraits.Vehicle

object ScalaTraits extends App {

  trait Vehicle {
    val typeVehicle: String
    val model: String

    def whatCan(): Unit

    def printInfo(): Unit = {
      print(s"$typeVehicle, модель: $model, я ")
      whatCan()
    }
  }

  case class Car(model: String) extends Vehicle {
    val typeVehicle = "Машина"
    override def whatCan(): Unit = println("могу быстро ездить")
  }

  case class Train(model: String) extends Vehicle {
    val typeVehicle = "Поезд"
    override def whatCan(): Unit = println("могу перевозить много людей")
  }

  case class Airplane(model: String) extends Vehicle {
    val typeVehicle = "Самолет"
    override def whatCan(): Unit = println("могу летать")
  }

  val car = Car("Феррари")
  val train = Train("Паровоз")
  val airplane = Airplane("Боинг")
  car.printInfo()
  train.printInfo()
  airplane.printInfo()

}


 object ScalaSelfTypes extends App {
   trait HasWings {
     val hasWings = "у меня есть крылья"
   }

   trait CanFlyInTheSky{
     this: HasWings =>
     def printCanFlyInTheSky:Unit = println(s"${this.getClass.getSimpleName}: Могу летать, потому что $hasWings")
   }

   case class Airplane(model: String) extends Vehicle with HasWings with CanFlyInTheSky {
     val typeVehicle = "Самолет"
     override def whatCan(): Unit = println("могу летать")
   }

   val airplane = Airplane("Боинг")
   airplane.printCanFlyInTheSky
 }

object ScalaAbstractClasses extends App {
  abstract class Figure(name: String) {
    def area: Int //= 0
    override def toString: String = s"Name: $name, area: $area"
  }
  case class Squre(name: String, side: Int) extends Figure(name) {
    override def area: Int = side * side
  }
  //val f = new Figure("a") // ce, like interface in java
  val s = Squre("d6", 2)
  println(s.name)
  println(s.side)
  println(s.area)
}

object Match extends App {
  import scala.util.Random
  val nextInt = Random.nextInt(10)

  nextInt match {
    case 0 => println("zero")
    case 1 => println("one")
    case 2 => println("two")
    //    case i => println(i)
    case _ => println("unknown")
  }

  // can return value
  val x = nextInt match {
    case 0 => "zero"
    case 1 => "one"
    case _ => "unknown"
  }
  println(x)

  def giveMeStr: String = nextInt match {
    case 0 => "zero"
    case 1 => "one"
    case _ => "unknown"
  }
  println(giveMeStr)
}

object CaseClassMatch extends App {
  trait Action
  case class Create(name: String)           extends Action
  case class Read(id: Long, maxSize: Int)   extends Action
  case class Update(id: Long, name: String) extends Action
  case class Delete(id: Long)               extends Action

  def checkMaxSize(ms: Int): Boolean = ms > 100 && ms < 150

  def processAction(ac: Action): Unit =
    ac match {
      case Create(name) =>
        println(s"Create $name")
      case Delete(id) =>
        println(s"Delete $id")
      // can be if maxSize > 100 && maxSize < 150, && can be ||
      case Read(id, maxSize) if checkMaxSize(maxSize) =>
        println(s"read with maxSize > 100")
      case Read(id, _) =>
        println(s"just read")
      case Update(id, name) =>
        println("update")
      case any =>
        println("any: " + any)
    }

  processAction(new Action {})
  processAction(Create("aaa"))
  processAction(Read(1, 101))
  processAction(Read(1, 99))

  def processActionV2(ac: Action): Unit =
    ac match {
      case c: Create =>
        println(s"Create ${c.name}")
      case d: Delete =>
        println(s"Delete ${d.id}")
      // can be if maxSize > 100 && maxSize < 150, && can be ||
      case r: Read if checkMaxSize(r.maxSize) =>
        println(s"read with maxSize > 100")
      case r: Read =>
        println(s"just read")
      case _: Update =>
        println("update")
      case any =>
        println("any: " + any)
    }
  processActionV2(new Action {})
  processActionV2(Create("aaa"))
  processActionV2(Read(1, 101))
  processActionV2(Read(1, 99))
}

sealed trait ActionV2
case class Create(name: String)           extends ActionV2
case class Read(id: Long, maxSize: Int)   extends ActionV2
case class Update(id: Long, name: String) extends ActionV2
case class Delete(id: Long)               extends ActionV2

object SealedCaseClassMatch extends App {
  def processActionV3(ac: ActionV2): Unit =
    ac match {
      case Create(name)      => println(1) // just for test
      case Read(id, maxSize) => println(2) // just for test
      case Update(id, name)  => println(3) // just for test
      //case _ => // drop
      //    case Delete(id) = println(4) warning on compile
    }
  processActionV3(Create("1123"))
}