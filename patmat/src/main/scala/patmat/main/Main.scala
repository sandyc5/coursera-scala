package patmat.main

import patmat.Huffman._

object Main extends App {
  val data = List("a", "a", "a", "b", "c", "c", "a")
  println(packx(data))
  println(encode(data))
  val data1 = List('a', 'a', 'a', 'b', 'c', 'c', 'a')
  println(times(data1))
  val trees = List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4))
  val s = until(singleton, combine)(trees)
  println("S " + s)
  //println(encode(data))

  def packx[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      println("first " + first)
      first :: packx(rest)
  }

  def encode[T](xs: List[T]): List[(T, Int)] =
    packx(xs) map (ys => (ys.head, ys.length))
    
  def isort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, isort(ys))

  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }    
}
