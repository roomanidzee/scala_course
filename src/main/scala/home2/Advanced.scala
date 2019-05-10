package home2

object Advanced extends App {

  // task 1: Implement the method for Vector[Int] and List[Int]
  //  sealed abstract class Addable[A] {
  //    def sum:A - какие здесь входные параметры?
  //  }
  //
  //
  //  class MyAddable[A] () extends Addable[A] {
  //    override def sum:A
  //  }
  //
  //  val myvec   = Vector (1,2,3)
  //  val mylist  = List   (1,2,3)
  //
  //  val inst  = new MyAddable
  //
  //  val res0  = inst.sum(mylist)
  //  val res1  = inst.sum(myvec)
  //
  //  println (s"res0 = $res0")
  //  println (s"res1 = $res1")

  sealed abstract class Addable[A] {
    def sum(item: Traversable[A]): A
  }

  class MyAddable[A: Numeric] extends Addable[A]{
    override def sum(item: Traversable[A]): A = item.sum
  }

  val testVec = Vector(1, 2, 3)
  val testList = List(1, 2, 3)
  val testMap = Map (1 -> "one",
                     2 -> "two",
                     3 -> "three")

  val inst = new MyAddable[Int]

  val res0 = inst.sum(testVec)
  val res1 = inst.sum(testList)
  val res2 = inst.sum(testMap.keys)

  println(s"Пример для Vector: $res0")
  println(s"Пример для List: $res1")
  println(s"Пример для Map: $res2")

}
