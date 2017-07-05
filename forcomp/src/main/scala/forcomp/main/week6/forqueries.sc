package forcomp.main.week6

import testmain._

object forqueries {
  /**
  * The for notation is essentially equivalent to the common operations of query languages for databases
  */
  
  
  
  // To find the titles of books whose author's name is "Bird" or Bloch
  
  for (b <- books; a <- b.authors if a startsWith "Bloch,") yield b.title
                                                  //> res0: List[String] = List(Effective Java, Java Puzzlers, Anothr Java book)
  
  // To find all the books which have the word "Program" in the title
  
  for (b <- books if b.title.indexOf("Program") >= 0) yield b.title
                                                  //> res1: List[String] = List(Structure and Interpretation of Computer Programs,
                                                  //|  Introduction to Functional Programming, Programming in Scala)
  for (b <- books if b.title.contains("Program")) yield b.title
                                                  //> res2: List[String] = List(Structure and Interpretation of Computer Programs,
                                                  //|  Introduction to Functional Programming, Programming in Scala)
  
  
  // To find the names of all authors who have written at least two books present in the database
  for {
  	b1 <- books
  	b2 <- books
  	if b1 != b2
  	a1 <- b1.authors
  	a2 <- b2.authors
  	if a1 == a2
  } yield a1                                      //> res3: List[String] = List(Bloch, Joshua, Bloch, Joshua, Bloch, Joshua, Bloch
                                                  //| , Joshua, Bloch, Joshua, Bloch, Joshua)
  
  // Why do solutions show up twice? List(Effective Java, Java Puzzlers), List(Java Puzzlers, Effective Java) ie reverse order
  // How can we avoid this?
  for {
  	b1 <- books
  	b2 <- books
  	if b1.title < b2.title
  	a1 <- b1.authors
  	a2 <- b2.authors
  	if a1 == a2
  } yield a1                                      //> res4: List[String] = List(Bloch, Joshua, Bloch, Joshua, Bloch, Joshua)
  
  //What happens if an author has published three books.  We have 3 possible pairs of books. So printed 3 times
  
  // We must remove duplicate authors who are in the results list twice using distinct method on sequences
  // OR BETTER Still replace List books with Set!!
                                                  
  (for {
  	b1 <- books
  	b2 <- books
  	if b1.title < b2.title
  	a1 <- b1.authors
  	a2 <- b2.authors
  	if a1 == a2
  } yield a1
  ).distinct                                      //> res5: List[String] = List(Bloch, Joshua)
                                                  
}