package forcomp.main.week6

import testmain._

object sortedGroupBy {
  /**
  * Two useful operations of SQL queries in addition to for-expressions are groupBy and orderBy
  */
  
  /**
  * orderBy on a collection can be expressed by sortWith and sorted
  */
  
  val fruit = List("apple","pear","orange","pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
  fruit sortWith (_.length < _.length)            //> res0: List[String] = List(pear, apple, orange, pineapple)
  
  fruit.sorted                                    //> res1: List[String] = List(apple, orange, pear, pineapple)
  
  /**
  * groupBy partitions a Scala collection into a map of collections according to a discriminator function f
  */
  
  fruit groupBy (_.head)                          //> res2: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
  
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
  }
  
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2) //> p1  : forcomp.main.week6.sortedGroupBy.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))      //> p2  : forcomp.main.week6.sortedGroupBy.Poly = 7.0x^3 + 3.0x^0
  
  p1 + p2                                         //> res3: forcomp.main.week6.sortedGroupBy.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3
                                                  //| .0x^0
  p1 addFold p2                                   //> res4: forcomp.main.week6.sortedGroupBy.Poly = 6.2x^5 + 11.0x^3 + 2.0x^1 + 3
                                                  //| .0x^0
  /**
  * Default Values
  * So far, maps where partial functions: Applying a map to a key value in map(key) could lead to an exception, if the key was not stored in the map
  *
  * There is an operation withDefaultValue that turns a map into a TOTAL FUNCTION
  */
  
  val cap1 = capitalOfCountry.withDefaultValue("<unknown>")
                                                  //> cap1  : scala.collection.immutable.Map[String,String] = Map(US -> Washingto
                                                  //| n, Switzerland -> Bern)
  
  cap1("Andorra")                                 //> res5: String = <unknown>
  
  p1.terms(7)                                     //> res6: Double = 0.0
}