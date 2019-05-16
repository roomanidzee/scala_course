package home1

// Home work for Lec1: Functions in Scala 
// Fix errors, rewrite functions or write your own implementations here 
// bku Apr 27 2019


object Simple extends App {

  // Fix error
  //--------------------------------------------------------------------------------------------
  def Func0 (a:Int):Some[Int] = {
    Some(-1*a)
  }

  val res0:Some[Int] = Func0(7)

  println(s"res0 = $res0")
  println(" ")

  // Rewrite to accept the lambda
  //--------------------------------------------------------------------------------------------

  def Func1(func: (Int, Int) => Int): Int = {
    func(1, 2)
  }

  val res1  = Func1 ((x:Int, y:Int) => 2*x + y)
  println(s"res1 = $res1")
  println(" ")

  // Curry Func2 and write the full curried definition, as in Func0
  //--------------------------------------------------------------------------------------------
  def Func2 (a:Int, b:Int, c:Int) = a + b + c
  def Func2Curried = (Func2 _).curried

  // f(x) = 1/x was definied as Partially Defined Function. Rewrite it with
  // A. pattern matching 
  // B. Option
  //--------------------------------------------------------------------------------------------

  def f0: PartialFunction[Int, Int] = new PartialFunction[Int, Int] {
    def apply(x: Int): Int = 1 / x
    def isDefinedAt(x: Int): Boolean = x != 0
  }

  def f0_match(x: Option[Int]): Int = x match {
    case Some(0) => -1
    case _ => 1 / x.get
  }

  // Higher order function (HOF) "reduce" from lecture notes returns incorrect result for the add reducer 
  // correct the error and implement a valid "reduce" for add and mul reducers
  //--------------------------------------------------------------------------------------------

  def reduce (arr:Vector[Int], f:(Int,Int) => Int ):Int  = {

    var temp = arr(0)

    for(i <- 1 until arr.length){

      val next = arr(i)
      temp = f(temp , next)

    }

    temp

  }

  // Write an implicit function to support the operation below
  //--------------------------------------------------------------------------------------------


  def doubleme (a:Int) = 2*a

  implicit def Func4(num: Float): Int = num.toInt

  val res2  = doubleme(2.5F)
  println(s"res2 = $res2")
  println(" ")


}

