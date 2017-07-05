package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  println(contains(singletonSet(2), 1))
  printSet(singletonSet(1))
  println(isNegative(-1))
  println(isNegative(1))
  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)

  val s = union(s1, s2)
  printSet(s)
  val t =  diff(s, s1)
  printSet(t)
  println(contains(t, 2))
  
  val s4 = union(s, s3)
  printSet(s4)
  val t2 =  filter(s4, x=> x > 2)
  printSet(t2)
  
  val forallTest =  forall(s4, x=> x < 4)
  println(forallTest)

  val mapTest = map(s4, x => x+5)
  printSet(mapTest)
}