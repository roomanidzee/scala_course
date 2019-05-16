package home2

object Simple extends App {

  // task 1: Dynamic Polymorphism
  // Implement a class hierarchy, according to the company.png UML diagram
  // Implement method def speak():Unit, which will display "I'm an employee", for example

  abstract class Coworker {
    def speak(): Unit = {
      println("I'm a coworker")
    }
  }

  trait Owner extends Coworker {
    override def speak(): Unit = {
      super.speak()
      println("I'm an owner")
    }
  }

  trait Manager extends Coworker {
    override def speak(): Unit = {
      super.speak()
      println("I'm a manager")
    }
  }

  trait Investor extends Coworker with Owner{
    override def speak(): Unit = {
      super.speak()
      println("I'm an investor")
    }
  }

  trait Employee extends Coworker with Manager{
    override def speak(): Unit = {
      super.speak()
      println("I'm an employee")
    }
  }

  trait Founder extends Coworker with Owner {
    override def speak(): Unit = {
      super.speak()
      println("I'm a founder")
    }
  }

  trait Engineer extends Coworker with Founder with Owner{
    override def speak(): Unit = {
      super.speak()
      println("I'm an engineer")
    }
  }

  trait Person extends Coworker with Founder with Employee{
    override def speak(): Unit = {
      super.speak()
      println("I'm a person")
    }
  }

  class FinalPerson(nickname: String) extends Coworker with Person{
    def represent(): Unit = {
      println(s"Hello! My nickname is $nickname and here are my characteristics:")
      println()
      speak()
    }
  }

  println("Task 1: ")
  println(" ")

  val fp1 = new FinalPerson("Testy")
  fp1.represent()
  println(" ")


  // task2: Parametric Polymorphism
  // Implement a correct version of the less() method for Int and String types

  class Duo[T] (first:T, second:T)(implicit ordering: Ordering[T]) {

    def less (): T = {

      import ordering._

      if ( first < second ) first else second

    }

  }

  println("Task 2:")
  println(" ")

  val integerDuo = new Duo[Int] (42, 23)
  val res0 = integerDuo.less()
  println(s"integerDuo: $res0")

  val stringDuo = new Duo[String]("version", "implementation")
  val res1 = stringDuo.less()
  println(s"stringDuo: $res1")
  println(" ")


  // task 3: Ad-hoc Polymorphism
  // Reimplement the reduce function from lec1 home work with ad-hoc Polymorphism. Implement both handwritten and library solutions

  println("Task 3: ")
  println(" ")

  trait Reducible[Int]{
    def initial: Int
    def reduce(vector: Vector[Int]): Int
  }

  def reducibleResult[Int](vector: Vector[Int])(implicit reducible: Reducible[Int]):Int = reducible.reduce(vector)

  implicit object AddReducible extends Reducible[Int] {
    override def initial: Int = 0
    override def reduce(vector: Vector[Int]): Int = vector.foldLeft(initial)(_ + _)
  }

  implicit object MultiplyReducible extends Reducible[Int] {
    override def initial: Int = 1
    override def reduce(vector: Vector[Int]): Int = vector.foldLeft(initial)(_ * _)
  }

  val testData = Vector(4, 8, 15, 16, 23, 42)

  println(s"add result: ${reducibleResult(testData)(AddReducible)}")
  println(s"multiply result: ${reducibleResult(testData)(MultiplyReducible)}")
  println(" ")


}
