package forcomp.main.week6
import testmain._

object forexpressions {
  /**
  * For-Expressions and Higher-Order Functions
  * The syntax of for is closely related to the higher-order functions map, flatMap and filter
  */
  
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  	for (x <- xs) yield f(x)                  //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
  	
  def flatMapx[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
  	for (x <- xs;
  			y <- f(x)) yield y        //> flatMapx: [T, U](xs: List[T], f: T => Iterable[U])List[U]
  			
  def filter[T](xs: List[T], p: T => Boolean): List[T] =
  	for (x <- xs if p(x)) yield x             //> filter: [T](xs: List[T], p: T => Boolean)List[T]
  	
  	
 	val s = "Hello World"                     //> s  : String = Hello World
 	//flatMapx(s.toList, c => List('.', c))
 	
 	/**
 	* In reality, the Scala compiler expresses for-expressions in terms of map, flatMap and a lazy variant of filter
 	*
 	* for (x <- e1) yield e2
 	*
 	* is translated to
 	*
 	* e1.map(x => e2)
 	*
 	* A for-expression
 	*
 	* for (x <- e1 if f; s) yield e2
 	*
 	* where f is a filter and s is a (potentially empty) sequence of generators and filters, is translated to
 	*
 	* for ( x <- e1.withFilter(x=> f); s) yield e2
 	*
 	* You can think of withFilter as a variant of filter that does not produce an intermediate list, but instead filters the following map or flatMap function applications
 	* Lazy and smarter than filter
 	*
 	* A for-expression
 	*
 	* for (x <- e1; y <- e2; s) yield e3
 	*
 	* where s is a (potentially empty) sequence of generators and filters, is translated to
 	*
 	* e1.flatMap(x => for (y <- e2; s) yield e3
 	*/
 	
	// Take the for-expression that computed pairs whose sum is prime:
	
	for {
		i <- 1 until 10
		j <- 1 until i
		if isPrime(i + j)
		} yield (i, j)                    //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 2), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6), (8,3), (8,5), (9,2), (
                                                  //| 9,4), (9,8))
		
	// Applying the translation scheme to this expression gives:
	
	(1 until 10).flatMap(i =>
		(1 until i).withFilter(j => isPrime(i+j))
		.map(j => (i, j)))                //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,
                                                  //| 2), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6), (8,3), (8,5), (9,2), (
                                                  //| 9,4), (9,8))
		
/**
* Exercise: Translate
*
* for (b <- books; a <-b.authors if a startsWith "Bird") yield b.title
*
* into higher-order function
*/

	books flatMap(b =>
		for { a <- b.authors if a.startsWith("Bird")} yield b.title)
                                                  //> res2: List[String] = List(Introduction to Functional Programming)
	books flatMap(b =>
		for { a <- b.authors withFilter(a => a.startsWith("Bird"))} yield b.title)
                                                  //> res3: List[String] = List(Introduction to Functional Programming)
		
	/*books.flatMap(b =>
		b.authors.withFilter(a => a.startsWith("Bird")).map(y => y.title))) */

	

	
}