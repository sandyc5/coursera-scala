package forcomp.main.week6
import testmain._

object forexpressions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(307); 
  /**
  * For-Expressions and Higher-Order Functions
  * The syntax of for is closely related to the higher-order functions map, flatMap and filter
  */
  
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  	for (x <- xs) yield f(x);System.out.println("""mapFun: [T, U](xs: List[T], f: T => U)List[U]""");$skip(111); 
  	
  def flatMapx[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
  	for (x <- xs;
  			y <- f(x)) yield y;System.out.println("""flatMapx: [T, U](xs: List[T], f: T => Iterable[U])List[U]""");$skip(96); 
  			
  def filter[T](xs: List[T], p: T => Boolean): List[T] =
  	for (x <- xs if p(x)) yield x;System.out.println("""filter: [T](xs: List[T], p: T => Boolean)List[T]""");$skip(32); 
  	
  	
 	val s = "Hello World";System.out.println("""s  : String = """ + $show(s ));$skip(1051); val res$0 = 
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
		} yield (i, j);System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(159); val res$1 = 
		
	// Applying the translation scheme to this expression gives:
	
	(1 until 10).flatMap(i =>
		(1 until i).withFilter(j => isPrime(i+j))
		.map(j => (i, j)));System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(220); val res$2 = 
		
/**
* Exercise: Translate
*
* for (b <- books; a <-b.authors if a startsWith "Bird") yield b.title
*
* into higher-order function
*/

	books flatMap(b =>
		for { a <- b.authors if a.startsWith("Bird")} yield b.title);System.out.println("""res2: List[String] = """ + $show(res$2));$skip(97); val res$3 = 
	books flatMap(b =>
		for { a <- b.authors withFilter(a => a.startsWith("Bird"))} yield b.title);System.out.println("""res3: List[String] = """ + $show(res$3))}
		
	/*books.flatMap(b =>
		b.authors.withFilter(a => a.startsWith("Bird")).map(y => y.title))) */

	

	
}
