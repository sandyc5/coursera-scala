package forcomp.main.week6
import testmain._

object test {
  val xs = Array(1,2,3,44)                        //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val s = "Hello World"                           //> s  : String = Hello World
  s filter (c => c.isUpper)                       //> res1: String = HW
  
  val r: Range = 1 until 5                        //> r  : Range = Range(1, 2, 3, 4)
  val t: Range = 1 to 5                           //> t  : Range = Range(1, 2, 3, 4, 5)
  val t2: Range = 1 to 10 by 3                    //> t2  : Range = Range(1, 4, 7, 10)
  val t3: Range = 6 to 1 by -2                    //> t3  : Range = Range(6, 4, 2)
  
  s exists (c => c.isUpper)                       //> res2: Boolean = true
  s forall (c => c.isUpper)                       //> res3: Boolean = false
  
  val pairs = List(1,2,3) zip s                   //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  
  // xs unzip
  // Splits a sequence of pairs xs into 2 sequences consisting of the first, respectively second halves of all pairs
  pairs unzip                                     //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  // xs flatMap f
  // Applies collection-valued function f to all elements of xs and concatenates the results
  s flatMap (c => List('.', c))                   //> res5: String = .H.e.l.l.o. .W.o.r.l.d
  
  xs.sum                                          //> res6: Int = 50
  xs.max                                          //> res7: Int = 44
  
  // To list all combinations of numbers x and y where x is drawn from 1 .. M and y is drawn from 1 .. N
  (1 to 10) flatMap ( x => (1 to 9) map (y => (x,y)))
                                                  //> res8: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,2
                                                  //| ), (1,3), (1,4), (1,5), (1,6), (1,7), (1,8), (1,9), (2,1), (2,2), (2,3), (2,
                                                  //| 4), (2,5), (2,6), (2,7), (2,8), (2,9), (3,1), (3,2), (3,3), (3,4), (3,5), (3
                                                  //| ,6), (3,7), (3,8), (3,9), (4,1), (4,2), (4,3), (4,4), (4,5), (4,6), (4,7), (
                                                  //| 4,8), (4,9), (5,1), (5,2), (5,3), (5,4), (5,5), (5,6), (5,7), (5,8), (5,9), 
                                                  //| (6,1), (6,2), (6,3), (6,4), (6,5), (6,6), (6,7), (6,8), (6,9), (7,1), (7,2),
                                                  //|  (7,3), (7,4), (7,5), (7,6), (7,7), (7,8), (7,9), (8,1), (8,2), (8,3), (8,4)
                                                  //| , (8,5), (8,6), (8,7), (8,8), (8,9), (9,1), (9,2), (9,3), (9,4), (9,5), (9,6
                                                  //| ), (9,7), (9,8), (9,9), (10,1), (10,2), (10,3), (10,4), (10,5), (10,6), (10,
                                                  //| 7), (10,8), (10,9))
  
  // To compute the scalar product of two vectors
  val ys = Array(2, 2)                            //> ys  : Array[Int] = Array(2, 2)
  
  (xs zip ys).map(xy => xy._1 * xy._2).sum        //> res9: Int = 6
  (xs zip ys).map{case (x,y) => x * y}.sum        //> res10: Int = 6
  
  val z = xs zip ys                               //> z  : Array[(Int, Int)] = Array((1,2), (2,2))
  val m = z map(xy => xy._1 * xy._2)              //> m  : Array[Int] = Array(2, 4)
  
  /**
  * Exercise, write a version of scalarProduct that makes use of a for:
  */
  
  def scalarProduct(xs: Array[Int], ys: Array[Int]) : Double = {
  	(for ((x, y) <- xs zip ys) yield x * y).sum
  }                                               //> scalarProduct: (xs: Array[Int], ys: Array[Int])Double
  
  scalarProduct(xs, ys)                           //> res11: Double = 6.0

  
  isPrime(3)                                      //> res12: Boolean = true
  
  /*** Handling Nested Sequences **/
  
 /***
 * Given a positive integer n, find all pairs of positive integers i and j, with
 * 1 <= j < i < n such that i + j is prime
 *
 * For example, if n = 7 the sought pairs are
 *
 * i |     2 3 4 4 5 6 6
 * ----------------------
 * j |     1 2 1 3 2 1 5
 * ----------------------
 * i + j | 3 5 5 7 7 7 11
 *
 * RESULT is Vector IndexedSeq
 **/
 
  val n = 7                                       //> n  : Int = 7
  val xss = (1 until n) map ( i =>
   (1 until i) map (j => (i, j)))                 //> xss  : scala.collection.immutable.IndexedSeq[scala.collection.immutable.Ind
                                                  //| exedSeq[(Int, Int)]] = Vector(Vector(), Vector((2,1)), Vector((3,1), (3,2))
                                                  //| , Vector((4,1), (4,2), (4,3)), Vector((5,1), (5,2), (5,3), (5,4)), Vector((
                                                  //| 6,1), (6,2), (6,3), (6,4), (6,5)))
   // xss gave us a sequence of sequences
   // We can combine all the sub-sequences using foldRight with ++
   (xss foldRight Seq[(Int, Int)]()) (_ ++ _ )    //> res13: Seq[(Int, Int)] = Vector((2,1), (3,1), (3,2), (4,1), (4,2), (4,3), (
                                                  //| 5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,3), (6,4), (6,5))
   // Or, equivalently, we use the built-in method flatten
   xss.flatten                                    //> res14: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), 
                                                  //| (6,3), (6,4), (6,5))
   
   // Here's a useful law:
   // xs flatMap f = (xs map f).flatten
   
   (1 until n) flatMap (i =>
   	(1 until i) map (j=> (i, j)))             //> res15: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,1), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), 
                                                  //| (6,3), (6,4), (6,5))
   (1 until n) flatMap (i =>
   	(1 until i) map (j=> (i, j)))  filter (pair =>
   	  isPrime(pair._1 + pair._2))             //> res16: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,2), (4,1), (4,3), (5,2), (6,1), (6,5))
  // => Hard to UNDERSTAND/READ
  // => Bring in For-expresson notation
  
  /**
  * Example, Let persons be a list of elements of class Person, with fields name and age
  * Obtain the names of persons over 20 years old
  *
  * case class Person(name: String, age: Int)
  *
  * for (p <- persons if p.age > 20) yield p.name
  *
  * which is equivalent to:
  *
  * persons filter (p=> p.age > 20) map (p => p.name)
  *
  * The for-expression is similar to loops in imperative languages, except that it builds a list of the results for all iteration
  *
  * NOTE: For expression in imperative programming produces side-effects, whilst Scala for expression produces new result (yield)
  */
   	
   
   for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i+j)
   } yield (i, j)                                 //> res17: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3
                                                  //| ,2), (4,1), (4,3), (5,2), (6,1), (6,5))
  
  
}