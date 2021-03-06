package streams.week7

object Streams {
  /**
  Collections and Combinatorial Search
	We’ve seen a number of immutable collections that provide powerful
	operations, in particular for combinatorial search.
	For instance, to ﬁnd the second prime number between 1000 and
	10000:
	((1000 to 10000) filter isPrime)(1)
	
	This is much shorter than the recursive alternative:
	
	def secondPrime(from: Int, to: Int) = nthPrime(from, to, 2)
	def nthPrime(from: Int, to: Int, n: Int): Int =
		if (from >= to) throw new Error(”no prime”)
		else if (isPrime(from))
			if (n == 1) from else nthPrime(from + 1, to, n - 1)
		else nthPrime(from + 1, to, n)
		
	Performance is pretty bad; it constructs all prime numbers between 1000 and
	10000 in a list, but only ever looks at the ﬁrst two elements of that
	list.
	Reducing the upper bound would speed things up, but risks that we
	miss the second prime number all together
	
	
	Streams are similar to lists, but their tail is evaluated only on demand. (Avoid computing the tail of a sequence until it is needed for the evaluation result (which may be never)
	
	Streams are defined from a constant Stream.empty and a constructor Stream.cons
	
	Tail is a Call by name parameter  => (not call by value)
  */
  
  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
                                                  //> xs  : Stream.Cons[Int] = Stream(1, ?)
  val s = Stream(1,2,3)                           //> s  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  (1 to 1000).toStream                            //> res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  def streamRange(lo: Int, hi: Int) : Stream[Int]  =
  	if (lo >= hi) Stream.empty
  	else Stream.cons(lo, streamRange(lo + 1, hi))
                                                  //> streamRange: (lo: Int, hi: Int)Stream[Int]
  	
 val sr = streamRange(1, 10)                      //> sr  : Stream[Int] = Stream(1, ?)
 
 def listRange(lo: Int, hi: Int): List[Int] =
 	if (lo >= hi) Nil
 	else lo :: listRange(lo + 1, hi)          //> listRange: (lo: Int, hi: Int)List[Int]

	val lr = listRange(1, 10)                 //> lr  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
	
	// ((1000 to 10000).toStream filter isPrime)(1)
	
	// NOTE: x :: xs always produces a list, never a stream
	// ALTERNATIVE: #:: can be used in expressions as well as patterns
	
	//x #:: xs == Stream.cons(x, xs)
	
	/**
	trait Stream[+A] extends Seq[A] {
		def isEmpty: Boolean
		def head: A
		def tail: Stream[A]
		...
	
	object Stream {
		def cons[T](hd: T, tl: => Stream[T]) = new Stream[T] {
			def isEmpty = false
			def head = hd
			def tail = tl
		}
		val empty = new Stream[Nothing] {
			def isEmpty = true
			def head = throw new NoSuchElementException(”empty.head”)
			def tail = throw new NoSuchElementException(”empty.tail”)
		}
	}
	
	
	class Stream[+T] {
	...
		def filter(p: T => Boolean): Stream[T] =
			if (isEmpty) this
			else if (p(head)) cons(head, tail.filter(p))
			else tail.filter(p)
		}
	
		def streamRange(lo: Int, hi: Int): Stream[Int] = {
			print(lo+” ”)
			if (lo >= hi) Stream.empty
			else Stream.cons(lo, streamRange(lo + 1, hi))
		}
	}
	*/
	
	
}