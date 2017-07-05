package streams.week7

object WaterPouring {
  val problem = new Pouring(Vector(4,9))          //> problem  : streams.week7.Pouring = streams.week7.Pouring@67d225a7
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with s
                                                  //| treams.week7.WaterPouring.problem.Move] = Vector(Empty(0), Empty(1), Fill(0)
                                                  //| , Fill(1), Pour(0,1), Pour(1,0))
  
  
  problem.pathSets.take(3).toList                 //> res1: List[Set[streams.week7.WaterPouring.problem.Path]] = List(Set(--> Vect
                                                  //| or(0, 0)), Set(Fill(0)--> Vector(4, 0), Fill(1)--> Vector(0, 9)), Set(Fill(0
                                                  //| ) Fill(1)--> Vector(4, 9), Fill(0) Pour(0,1)--> Vector(0, 4), Fill(1) Fill(0
                                                  //| )--> Vector(4, 9), Fill(1) Pour(1,0)--> Vector(4, 5)))
  
  problem.solutions(6).take(3).toList             //> res2: List[streams.week7.WaterPouring.problem.Path] = List(Fill(1) Pour(1,0)
                                                  //|  Empty(0) Pour(1,0) Empty(0) Pour(1,0) Fill(1) Pour(1,0)--> Vector(4, 6), Fi
                                                  //| ll(1) Pour(1,0) Empty(0) Pour(1,0) Empty(0) Pour(1,0) Fill(1) Pour(1,0) Empt
                                                  //| y(0)--> Vector(0, 6))
  
}