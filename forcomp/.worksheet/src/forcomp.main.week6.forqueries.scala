package forcomp.main.week6

import testmain._

object forqueries {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(340); val res$0 = 
  /**
  * The for notation is essentially equivalent to the common operations of query languages for databases
  */
  
  
  
  // To find the titles of books whose author's name is "Bird" or Bloch
  
  for (b <- books; a <- b.authors if a startsWith "Bloch,") yield b.title;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(144); val res$1 = 
  
  // To find all the books which have the word "Program" in the title
  
  for (b <- books if b.title.indexOf("Program") >= 0) yield b.title;System.out.println("""res1: List[String] = """ + $show(res$1));$skip(64); val res$2 = 
  for (b <- books if b.title.contains("Program")) yield b.title;System.out.println("""res2: List[String] = """ + $show(res$2));$skip(225); val res$3 = 
  
  
  // To find the names of all authors who have written at least two books present in the database
  for {
  	b1 <- books
  	b2 <- books
  	if b1 != b2
  	a1 <- b1.authors
  	a2 <- b2.authors
  	if a1 == a2
  } yield a1;System.out.println("""res3: List[String] = """ + $show(res$3));$skip(290); val res$4 = 
  
  // Why do solutions show up twice? List(Effective Java, Java Puzzlers), List(Java Puzzlers, Effective Java) ie reverse order
  // How can we avoid this?
  for {
  	b1 <- books
  	b2 <- books
  	if b1.title < b2.title
  	a1 <- b1.authors
  	a2 <- b2.authors
  	if a1 == a2
  } yield a1;System.out.println("""res4: List[String] = """ + $show(res$4));$skip(473); val res$5 = 
  
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
  ).distinct;System.out.println("""res5: List[String] = """ + $show(res$5))}
                                                  
}
