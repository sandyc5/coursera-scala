package streams.week7

object Lazy {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(166); 
  def expr = {
  	val x = {print("x"); 1}
  	lazy val y = {print("y"); 2}
  	def z = {print("z"); 3}
  	z + y + x + z + y + x
  };System.out.println("""expr: => Int""");$skip(7); val res$0 = 
  expr;System.out.println("""res0: Int = """ + $show(res$0));$skip(124); 
  
  // Here is the stream of all integers starting from a given number:
  def from (n: Int): Stream[Int] = n #:: from(n+1);System.out.println("""from: (n: Int)Stream[Int]""");$skip(62); 
  
  //The stream of all natural number:
  val nats = from(0);System.out.println("""nats  : Stream[Int] = """ + $show(nats ));$skip(10); val res$1 = 
  nats(3);System.out.println("""res1: Int = """ + $show(res$1));$skip(67); 
  
  //The stream of all multiples of 4:
  val n = nats map(_ * 4);System.out.println("""n  : scala.collection.immutable.Stream[Int] = """ + $show(n ));$skip(10); val res$2 = 
  
  n(4);System.out.println("""res2: Int = """ + $show(res$2));$skip(10); val res$3 = 
  nats(4);System.out.println("""res3: Int = """ + $show(res$3));$skip(24); val res$4 = 
  
  (n take 10).toList;System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(102); 
  
  
  def sieve(s: Stream[Int]): Stream[Int] =
  	s.head #:: sieve(s.tail filter (_ % s.head != 0));System.out.println("""sieve: (s: Stream[Int])Stream[Int]""");$skip(34); 
  	
 	val primes = sieve(from(2));System.out.println("""primes  : Stream[Int] = """ + $show(primes ));$skip(29); val res$5 = 
 	
 	(primes take 10).toList;System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(185); 
 	
 	def sqrtStream(x: Double): Stream[Double] = {
 		def improve(guess: Double) = (guess + x/guess) /2
 		lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
 		guesses
 	};System.out.println("""sqrtStream: (x: Double)Stream[Double]""");$skip(48); 
 	
 	val sqrt = (sqrtStream(16) take 10).toList;System.out.println("""sqrt  : List[Double] = """ + $show(sqrt ));$skip(96); 
 	
 	def isGoodEnough(guess: Double, x: Double) =
 		math.abs((guess * guess - x) / x) < 0.0001;System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(66); val res$6 = 
 		
 	(sqrtStream(16).filter(isGoodEnough(_, 16)) take 10).toList;System.out.println("""res6: List[Double] = """ + $show(res$6))}
 	
 	// map operation is more efficient because it doesn't generate unnecessary stream elements that are filtered out afterwards.
 		
}
