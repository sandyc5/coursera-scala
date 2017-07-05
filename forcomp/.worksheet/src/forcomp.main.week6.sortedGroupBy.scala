package forcomp.main.week6

import testmain._

object sortedGroupBy {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(317); 
  /**
  * Two useful operations of SQL queries in addition to for-expressions are groupBy and orderBy
  */
  
  /**
  * orderBy on a collection can be expressed by sortWith and sorted
  */
  
  val fruit = List("apple","pear","orange","pineapple");System.out.println("""fruit  : List[String] = """ + $show(fruit ));$skip(39); val res$0 = 
  fruit sortWith (_.length < _.length);System.out.println("""res0: List[String] = """ + $show(res$0));$skip(18); val res$1 = 
  
  fruit.sorted;System.out.println("""res1: List[String] = """ + $show(res$1));$skip(150); val res$2 = 
  
  /**
  * groupBy partitions a Scala collection into a map of collections according to a discriminator function f
  */
  
  fruit groupBy (_.head)
  
  /**
  * Map Example:
  * A polynomial can be seen as a map from exponents to coefficients
  * For instance, x(to power of 3) - 2 x + 5 can be represented with the map
  *
  * Map (0 -> 5, 1 -> -2, 3 -> 1)
  *
  * Based on this observation, let's design a class Polynom that represents polynomials as maps.
  */
  
  class Poly(val terms0: Map[Int, Double]) {
  	def this(bindings: (Int, Double)*) = this(bindings.toMap)
  	val terms = terms0 withDefaultValue (0.0)
  	def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  	
  	// More efficient ass does not concat to create new map
  	def addFold(other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
  	
  	def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
  		val (exp, coeff) = term
  		terms + (exp -> (coeff + terms(exp)))
  	}
  	
  	def adjust(term: (Int, Double)): (Int, Double) = {
  		val (exp, coeff) = term
  		/*terms get exp match {
  			case Some(coeff1) => exp -> (coeff + coeff1)
  			case None => exp -> coeff
  		}*/
  		exp -> (coeff + terms(exp))
  	}
  	
  	override def toString =
  		(for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^"+exp) mkString " + "
  };System.out.println("""res2: scala.collection.immutable.Map[Char,List[String]] = """ + $show(res$2));$skip(1264); 
  
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2);System.out.println("""p1  : forcomp.main.week6.sortedGroupBy.Poly = """ + $show(p1 ));$skip(45); 
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0));System.out.println("""p2  : forcomp.main.week6.sortedGroupBy.Poly = """ + $show(p2 ));$skip(13); val res$3 = 
  
  p1 + p2;System.out.println("""res3: forcomp.main.week6.sortedGroupBy.Poly = """ + $show(res$3));$skip(16); val res$4 = 
  p1 addFold p2;System.out.println("""res4: forcomp.main.week6.sortedGroupBy.Poly = """ + $show(res$4));$skip(328); 
  /**
  * Default Values
  * So far, maps where partial functions: Applying a map to a key value in map(key) could lead to an exception, if the key was not stored in the map
  *
  * There is an operation withDefaultValue that turns a map into a TOTAL FUNCTION
  */
  
  val cap1 = capitalOfCountry.withDefaultValue("<unknown>");System.out.println("""cap1  : scala.collection.immutable.Map[String,String] = """ + $show(cap1 ));$skip(21); val res$5 = 
  
  cap1("Andorra");System.out.println("""res5: String = """ + $show(res$5));$skip(17); val res$6 = 
  
  p1.terms(7);System.out.println("""res6: Double = """ + $show(res$6))}
}
