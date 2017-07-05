package forcomp.main.week6
import testmain._

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(86); 
  val xs = Array(1,2,3,44);System.out.println("""xs  : Array[Int] = """ + $show(xs ));$skip(22); val res$0 = 
  xs map (x => x * 2);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(27); 
  
  val s = "Hello World";System.out.println("""s  : String = """ + $show(s ));$skip(28); val res$1 = 
  s filter (c => c.isUpper);System.out.println("""res1: String = """ + $show(res$1));$skip(30); 
  
  val r: Range = 1 until 5;System.out.println("""r  : Range = """ + $show(r ));$skip(24); 
  val t: Range = 1 to 5;System.out.println("""t  : Range = """ + $show(t ));$skip(31); 
  val t2: Range = 1 to 10 by 3;System.out.println("""t2  : Range = """ + $show(t2 ));$skip(31); 
  val t3: Range = 6 to 1 by -2;System.out.println("""t3  : Range = """ + $show(t3 ));$skip(31); val res$2 = 
  
  s exists (c => c.isUpper);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(28); val res$3 = 
  s forall (c => c.isUpper);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(35); 
  
  val pairs = List(1,2,3) zip s;System.out.println("""pairs  : List[(Int, Char)] = """ + $show(pairs ));$skip(148); val res$4 = 
  
  // xs unzip
  // Splits a sequence of pairs xs into 2 sequences consisting of the first, respectively second halves of all pairs
  pairs unzip;System.out.println("""res4: (List[Int], List[Char]) = """ + $show(res$4));$skip(146); val res$5 = 
  
  // xs flatMap f
  // Applies collection-valued function f to all elements of xs and concatenates the results
  s flatMap (c => List('.', c));System.out.println("""res5: String = """ + $show(res$5));$skip(12); val res$6 = 
  
  xs.sum;System.out.println("""res6: Int = """ + $show(res$6));$skip(9); val res$7 = 
  xs.max;System.out.println("""res7: Int = """ + $show(res$7));$skip(162); val res$8 = 
  
  // To list all combinations of numbers x and y where x is drawn from 1 .. M and y is drawn from 1 .. N
  (1 to 10) flatMap ( x => (1 to 9) map (y => (x,y)));System.out.println("""res8: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$8));$skip(76); 
  
  // To compute the scalar product of two vectors
  val ys = Array(2, 2);System.out.println("""ys  : Array[Int] = """ + $show(ys ));$skip(46); val res$9 = 
  
  (xs zip ys).map(xy => xy._1 * xy._2).sum;System.out.println("""res9: Int = """ + $show(res$9));$skip(43); val res$10 = 
  (xs zip ys).map{case (x,y) => x * y}.sum;System.out.println("""res10: Int = """ + $show(res$10));$skip(23); 
  
  val z = xs zip ys;System.out.println("""z  : Array[(Int, Int)] = """ + $show(z ));$skip(37); 
  val m = z map(xy => xy._1 * xy._2);System.out.println("""m  : Array[Int] = """ + $show(m ));$skip(205); 
  
  /**
  * Exercise, write a version of scalarProduct that makes use of a for:
  */
  
  def scalarProduct(xs: Array[Int], ys: Array[Int]) : Double = {
  	(for ((x, y) <- xs zip ys) yield x * y).sum
  };System.out.println("""scalarProduct: (xs: Array[Int], ys: Array[Int])Double""");$skip(27); val res$11 = 
  
  scalarProduct(xs, ys);System.out.println("""res11: Double = """ + $show(res$11));$skip(17); val res$12 = 

  
  isPrime(3);System.out.println("""res12: Boolean = """ + $show(res$12));$skip(406); 
  
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
 
  val n = 7;System.out.println("""n  : Int = """ + $show(n ));$skip(69); 
  val xss = (1 until n) map ( i =>
   (1 until i) map (j => (i, j)));System.out.println("""xss  : scala.collection.immutable.IndexedSeq[scala.collection.immutable.IndexedSeq[(Int, Int)]] = """ + $show(xss ));$skip(156); val res$13 = 
   // xss gave us a sequence of sequences
   // We can combine all the sub-sequences using foldRight with ++
   (xss foldRight Seq[(Int, Int)]()) (_ ++ _ );System.out.println("""res13: Seq[(Int, Int)] = """ + $show(res$13));$skip(74); val res$14 = 
   // Or, equivalently, we use the built-in method flatten
   xss.flatten;System.out.println("""res14: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$14));$skip(138); val res$15 = 
   
   // Here's a useful law:
   // xs flatMap f = (xs map f).flatten
   
   (1 until n) flatMap (i =>
   	(1 until i) map (j=> (i, j)));System.out.println("""res15: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$15));$skip(114); val res$16 = 
   (1 until n) flatMap (i =>
   	(1 until i) map (j=> (i, j)))  filter (pair =>
   	  isPrime(pair._1 + pair._2));System.out.println("""res16: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$16));$skip(781); val res$17 = 
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
   } yield (i, j);System.out.println("""res17: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$17))}
  
  
}
