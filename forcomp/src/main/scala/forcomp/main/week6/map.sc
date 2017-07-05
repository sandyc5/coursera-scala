package forcomp.main.week6

import testmain._

object map {
	/**
	* A map of type Map[Key, Value]
	* is a data structure that associates keys of type Key with values of type Value.
	*/
	
	// :Map[String, Int]
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V 
                                                  //| -> 5, X -> 10)
  
  
  
  
  /**
  * Class Map[Key, Value] also extends the function type Key => Value, so maps can be used everywhere functions can.
  */
  capitalOfCountry("US")                          //> res0: String = Washington
  
  /**
  * Applying a map to a non-existing key gives an error:
  * capitalOfCountry("Andorra") // java.util.NoSuchElementException: key not found: Andorra
  */
  
  //capitalOfCountry("Andorra")
  
  /**
  * To query a map without knowing beforehand whether it contains a given key, you can use the get operation
  * The result of a get operations is an Option value
  */
  capitalOfCountry get "US"                       //> res1: Option[String] = Some(Washington)
  capitalOfCountry get "Andorra"                  //> res2: Option[String] = None
  
  /**
  * The Option type is defined as:
  * trait Option[+A]
  * case class Some[+A](value: A) extends Option[A]
  * Object None extends Option[Nothing]
  *
  * The expression map get key returnds
  *
  * None if map does not contain the given key
  * Some(x) if map associates the given key with the value x
  */
  
  
  /**
  * Since options are defined as case classes, they can be decomposed using pattern matching
  */
  
  def showCapital(country: String) = capitalOfCountry.get(country) match {
  	case Some(capital) => capital
  	case None => "missing data"
  }                                               //> showCapital: (country: String)String
  
  showCapital("US")                               //> res3: String = Washington
  showCapital("Andorra")                          //> res4: String = missing data
}