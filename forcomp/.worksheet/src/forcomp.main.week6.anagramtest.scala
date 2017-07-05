package forcomp.main.week6
import forcomp.Anagrams._

object anagramtest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(91); 

	val w = "abcd";System.out.println("""w  : String = """ + $show(w ));$skip(20); 
	val r = "Robbbert";System.out.println("""r  : String = """ + $show(r ));$skip(20); 
	
	val s = r.toList;System.out.println("""s  : List[Char] = """ + $show(s ));$skip(72); 
	
	
	val x = r.groupBy(_.toChar.toLower).map{ p => (p._1, p._2.length)};System.out.println("""x  : scala.collection.immutable.Map[Char,Int] = """ + $show(x ));$skip(20); 
	
	val t = x.toList;System.out.println("""t  : List[(Char, Int)] = """ + $show(t ));$skip(30); 
	
	val l = List("abcd", "ed");System.out.println("""l  : List[String] = """ + $show(l ));$skip(137); 
	
	
	
	def wordOccurrences(w: String): List[(Char, Int)] =
  	(w.groupBy(_.toChar.toLower).map{ p => (p._1, p._2.length)}).toList sorted;System.out.println("""wordOccurrences: (w: String)List[(Char, Int)]""");$skip(368); 
	
	
	def sentenceOccurrences(sentence: List[String]): List[(Char, Int)] =
  	/*if (number.isEmpty) List()
  	else
  		for {
  			split <- 1 to number.length
  			word <- wordOccurrences(split)
  			rest <- sentenceOccurrences(number drop split)
  		} yield word :: rest*/
  		
  			/*sentence.flatMap(b =>
		wordOccurrences(b)) */
		wordOccurrences(sentence.mkString);System.out.println("""sentenceOccurrences: (sentence: List[String])List[(Char, Int)]""");$skip(28); val res$0 = 
  		
  		wordOccurrences(r);System.out.println("""res0: List[(Char, Int)] = """ + $show(res$0));$skip(27); val res$1 = 
  		sentenceOccurrences(l);System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1));$skip(46); 
  		
  		val jimmy = wordOccurrences("jimmy");System.out.println("""jimmy  : List[(Char, Int)] = """ + $show(jimmy ));$skip(40); 
  		
  		val my = wordOccurrences("my");System.out.println("""my  : List[(Char, Int)] = """ + $show(my ));$skip(42); 
  		
  		val jim = wordOccurrences("jim");System.out.println("""jim  : List[(Char, Int)] = """ + $show(jim ));$skip(56); 
  		
  		val assessment = wordOccurrences("assessment");System.out.println("""assessment  : List[(Char, Int)] = """ + $show(assessment ));$skip(46); 
       val assess = wordOccurrences("assess");System.out.println("""assess  : List[(Char, Int)] = """ + $show(assess ));$skip(50); 
       
       val ment = wordOccurrences("ment");System.out.println("""ment  : List[(Char, Int)] = """ + $show(ment ));$skip(28); val res$2 = 
	
      subtract(jimmy, my);System.out.println("""res2: forcomp.Anagrams.Occurrences = """ + $show(res$2));$skip(100); val res$3 = 
      
      
    for {
      xs <- jimmy
      ys <- my
      if (xs._1 != ys._1)
    } yield (xs);System.out.println("""res3: List[(Char, Int)] = """ + $show(res$3))}
           /*
           (1 until 10).flatMap(i =>
		(1 until i).withFilter(j => isPrime(i+j))
		.map(j => (i, j))) */
	
	//x flatMap groupBy(_.toChar)
	//x groupBy (_)

}
