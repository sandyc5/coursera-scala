package forcomp.main.week6

object testmain {
  
  case class Book(title: String, authors: List[String])
  
 /**
  * Example, Suppose that we have a database books, represented as a list of books
  */
  val books: List[Book] =
  List(Book(title="Structure and Interpretation of Computer Programs",authors = List("Abelson, Harald", "Sussman, Gerald J.")),
  Book(title = "Introduction to Functional Programming", authors = List("Bird, Richard", "Wadler, Phil")),
  Book(title = "Effective Java", authors = List("Bloch, Joshua")),
  Book(title = "Java Puzzlers", authors = List("Bloch, Joshua", "Gafter, Neal")),
  Book(title = "Programming in Scala", authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")),
  Book(title = "Anothr Java book", authors = List("Bloch, Joshua")))


    // A number n is prime if the only divisors of n are 1 and n itself
  // What is a high-level way to write a test for primality of numbers?
  // For once, value consiseness over efficiency
  
  def isPrime(n: Int): Boolean = {
  	(2 until n) forall (d => n % d != 0)
  }                                               //> isPrime: (n: Int)Boolean

  // :Map [String, String]
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")


}