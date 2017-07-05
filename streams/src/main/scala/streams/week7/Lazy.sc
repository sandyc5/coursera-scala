package streams.week7

object Lazy {
  def expr = {
  	val x = {print("x"); 1}
  	lazy val y = {print("y"); 2}
  	def z = {print("z"); 3}
  	z + y + x + z + y + x
  }                                               //> expr: => Int
  expr                                            //> xzyzres0: Int = 12
  
  // Here is the stream of all integers starting from a given number:
  def from (n: Int): Stream[Int] = n #:: from(n+1)//> from: (n: Int)Stream[Int]
  
  //The stream of all natural number:
  val nats = from(0)                              //> nats  : Stream[Int] = Stream(0, ?)
  nats(3)                                         //> res1: Int = 3
  
  //The stream of all multiples of 4:
  val n = nats map(_ * 4)                         //> n  : scala.collection.immutable.Stream[Int] = Stream(0, ?)
  
  n(4)                                            //> res2: Int = 16
  nats(4)                                         //> res3: Int = 4
  
  (n take 10).toList                              //> res4: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36)
  
  
  def sieve(s: Stream[Int]): Stream[Int] =
  	s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]
  	
 	val primes = sieve(from(2))               //> primes  : Stream[Int] = Stream(2, ?)
 	
 	(primes take 10).toList                   //> res5: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
 	
 	def sqrtStream(x: Double): Stream[Double] = {
 		def improve(guess: Double) = (guess + x/guess) /2
 		lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
 		guesses
 	}                                         //> sqrtStream: (x: Double)Stream[Double]
 	
 	val sqrt = (sqrtStream(16) take 10).toList//> sqrt  : List[Double] = List(1.0, 8.5, 5.1911764705882355, 4.136664722546242,
                                                  //|  4.002257524798522, 4.000000636692939, 4.000000000000051, 4.0, 4.0, 4.0)
 	
 	def isGoodEnough(guess: Double, x: Double) =
 		math.abs((guess * guess - x) / x) < 0.0001
                                                  //> isGoodEnough: (guess: Double, x: Double)Boolean
 		
 	(sqrtStream(16).filter(isGoodEnough(_, 16)) take 10).toList
                                                  //> res6: List[Double] = List(4.000000636692939, 4.000000000000051, 4.0, 4.0, 4
                                                  //| .0, 4.0, 4.0, 4.0, 4.0, 4.0)
 	
 	// map operation is more efficient because it doesn't generate unnecessary stream elements that are filtered out afterwards.
 		
}