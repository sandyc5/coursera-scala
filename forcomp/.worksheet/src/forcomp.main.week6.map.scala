package forcomp.main.week6

import testmain._

object map {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(265); 
	/**
	* A map of type Map[Key, Value]
	* is a data structure that associates keys of type Key with values of type Value.
	*/
	
	// :Map[String, Int]
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10);System.out.println("""romanNumerals  : scala.collection.immutable.Map[String,Int] = """ + $show(romanNumerals ));$skip(165); val res$0 = 
  
  
  
  
  /**
  * Class Map[Key, Value] also extends the function type Key => Value, so maps can be used everywhere functions can.
  */
  capitalOfCountry("US");System.out.println("""res0: String = """ + $show(res$0));$skip(403); val res$1 = 
  
  /**
  * Applying a map to a non-existing key gives an error:
  * capitalOfCountry("Andorra") // java.util.NoSuchElementException: key not found: Andorra
  */
  
  //capitalOfCountry("Andorra")
  
  /**
  * To query a map without knowing beforehand whether it contains a given key, you can use the get operation
  * The result of a get operations is an Option value
  */
  capitalOfCountry get "US";System.out.println("""res1: Option[String] = """ + $show(res$1));$skip(33); val res$2 = 
  capitalOfCountry get "Andorra";System.out.println("""res2: Option[String] = """ + $show(res$2));$skip(574); 
  
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
  };System.out.println("""showCapital: (country: String)String""");$skip(23); val res$3 = 
  
  showCapital("US");System.out.println("""res3: String = """ + $show(res$3));$skip(25); val res$4 = 
  showCapital("Andorra");System.out.println("""res4: String = """ + $show(res$4))}
}
