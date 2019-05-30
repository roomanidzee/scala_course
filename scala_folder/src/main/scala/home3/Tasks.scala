package home3

import scala.collection.mutable

/**
  * scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
  *
  * scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
  */

/**
  * (**) Extract a given number of randomly selected elements from a list.
  * Example:
  * scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  * res0: List[Symbol] = List('e, 'd, 'a)
  */

object Tasks extends App{

  val x = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

  def slice(i: Int, k: Int, list: List[Symbol]): List[Symbol] = list.slice(i, k)

  println(slice(3,7,x))

  def rotate(number: Int, symbols: List[Symbol]): List[Symbol] ={

    if(number >= 0){
      symbols.drop(number) ++ symbols.take(number)
    }

    else{
      symbols.takeRight(Math.abs(number)) ++ symbols.dropRight(Math.abs(number))
    }
  }

  println("P19")
  println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  println(rotate(0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  println(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

  def randomSelect(number: Int, symbols: List[Symbol]): List[Symbol] = {
    val rnd = new scala.util.Random
    val res: mutable.MutableList[Symbol] = mutable.MutableList()

    (1 to number).foreach(i => res += symbols(rnd.nextInt(symbols.length)))

    res.toList

  }

  println("P23 ")
  println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))


}
