package home4

import scala.collection.mutable.{MutableList, StringBuilder}

object P94 extends App{

  class GraphImpl{

    var vertexNumber: Int = 0
    var edgeNumber: Int = 0
    var adjacency: MutableList[MutableList[Int]] = MutableList[MutableList[Int]]()

    def this(vertexNumber: Int){

      this()

      this.vertexNumber = vertexNumber

      (0 until this.vertexNumber).foreach(i => adjacency += MutableList[Int]())

    }

    override def toString: String = {

      val sb: StringBuilder = StringBuilder.newBuilder
      sb.append(s"Вершин: ${this.vertexNumber}, ребер: ${this.edgeNumber} \n")

      (0 until this.vertexNumber)
        .foreach(i => {

          sb.append(s"$i: ")

          this.adjacency(i).foreach(item => sb.append(item))

          sb.append("\n")

        })

      sb.toString()

    }

    def validateVertex(vertex: Int): Unit = {

      if(vertex < 0 || vertex >= this.vertexNumber){
        throw new IllegalArgumentException(s"Вершина $vertex не находится между 0 и ${this.vertexNumber - 1}")
      }

    }

    def addEdge(firstVertex: Int, secondVertex: Int): Unit = {

      this.validateVertex(firstVertex)
      this.validateVertex(secondVertex)
      this.edgeNumber += 1

      this.adjacency(firstVertex) += secondVertex
      this.adjacency(secondVertex) += firstVertex

    }

  }

  def generateRegularGraph(k: Int, n: Int): GraphImpl = {

    val graph: GraphImpl = new GraphImpl(n)

    val vertexArray: Array[Int] = new Array[Int](k * n)

    (0 until n)
      .foreach(i => (0 until k)
        .foreach(j => vertexArray(i + n * j) = i))

    val limit: Int = k * n / 2

    (0 until limit).foreach(i => graph.addEdge(vertexArray(2 * i), vertexArray(2 * i + 1)))

    graph

  }

  println(generateRegularGraph(2, 3))

}
