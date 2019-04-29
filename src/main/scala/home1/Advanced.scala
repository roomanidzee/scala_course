package home1

object Advanced extends App {

  def Sum (vec:Vector[Int]):Int = ???

  // Task 1

  // Implement a function, which sums all elevements in the int vector in several different ways

  // With a lib function
  // Using vars
  // using immutables only
  // using for iteration
  // using recursion
  // your own idea

  var vec = Vector (-1,2,4)

  def sumLib(vec: Vector[Int]): Int = vec.sum

  def sumVar(vec: Vector[Int]): Int = {

    val len = vec.length

    var counter = 0
    var result = 0

    while(counter != len){
      result += vec(counter)
      counter += 1
    }

    result

  }

  def sumImmutable(vec: Vector[Int]): Int = {
    // класс vector - Immutable
    vec.sum
  }

  def sumIteration(vec: Vector[Int]): Int = {

    var counter = 0

    for(i <- 0 until vec.length){
      counter += vec(i)
    }

    counter

  }

  def sumRecursive(vec: Vector[Int]): Int = {

    //здесь должен быть pattern matching, но додумал только так:
    vec.foldLeft(0)(_ + _)

  }

  val res1 = sumLib(vec)
  val res2 = sumVar(vec)
  val res3 = sumImmutable(vec)
  val res4 = sumIteration(vec)
  val res5 = sumRecursive(vec)

  println(s"with lib function: $res1")
  println(s"with vars: $res2")
  println(s"with immutables: $res3")
  println(s"with iteration: $res4")
  println(s"with recursive: $res5")



  // Task 2

  // For recursive Implementation, can you implement a function, which sums up very large vectors? What are potential dangers for a recursive implementation?

  //Опасность - StackOverflowError, или же OutOfMemoryError

}
