package forcomp.main.week6
import forcomp.Anagrams._

object anagramtest {

	val w = "abcd"                            //> w  : String = abcd
	val r = "Robbbert"                        //> r  : String = Robbbert
	
	val s = r.toList                          //> s  : List[Char] = List(R, o, b, b, b, e, r, t)
	
	
	val x = r.groupBy(_.toChar.toLower).map{ p => (p._1, p._2.length)}
                                                  //> x  : scala.collection.immutable.Map[Char,Int] = Map(e -> 1, t -> 1, b -> 3, 
                                                  //| r -> 2, o -> 1)
	
	val t = x.toList                          //> t  : List[(Char, Int)] = List((e,1), (t,1), (b,3), (r,2), (o,1))
	
	val l = List("abcd", "ed")                //> l  : List[String] = List(abcd, ed)
	
	
	
	def wordOccurrences(w: String): List[(Char, Int)] =
  	(w.groupBy(_.toChar.toLower).map{ p => (p._1, p._2.length)}).toList sorted
                                                  //> wordOccurrences: (w: String)List[(Char, Int)]
	
	
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
		wordOccurrences(sentence.mkString)//> sentenceOccurrences: (sentence: List[String])List[(Char, Int)]
  		
  		wordOccurrences(r)                //> res0: List[(Char, Int)] = List((b,3), (e,1), (o,1), (r,2), (t,1))
  		sentenceOccurrences(l)            //> res1: List[(Char, Int)] = List((a,1), (b,1), (c,1), (d,2), (e,1))
  		
  		val jimmy = wordOccurrences("jimmy")
                                                  //> jimmy  : List[(Char, Int)] = List((i,1), (j,1), (m,2), (y,1))
  		
  		val my = wordOccurrences("my")    //> my  : List[(Char, Int)] = List((m,1), (y,1))
  		
  		val jim = wordOccurrences("jim")  //> jim  : List[(Char, Int)] = List((i,1), (j,1), (m,1))
  		
  		val assessment = wordOccurrences("assessment")
                                                  //> assessment  : List[(Char, Int)] = List((a,1), (e,2), (m,1), (n,1), (s,4), (t
                                                  //| ,1))
       val assess = wordOccurrences("assess")     //> assess  : List[(Char, Int)] = List((a,1), (e,1), (s,4))
       
       val ment = wordOccurrences("ment")         //> ment  : List[(Char, Int)] = List((e,1), (m,1), (n,1), (t,1))
	
      subtract(jimmy, my)                         //> res2: forcomp.Anagrams.Occurrences = List((i,1), (i,1), (j,1), (j,1), (m,2)
                                                  //| , (y,1), (m,1))
      
      
    for {
      xs <- jimmy
      ys <- my
      if (xs._1 != ys._1)
    } yield (xs)                                  //> res3: List[(Char, Int)] = List((i,1), (i,1), (j,1), (j,1), (m,2), (y,1))
           /*
           (1 until 10).flatMap(i =>
		(1 until i).withFilter(j => isPrime(i+j))
		.map(j => (i, j))) */
	
	//x flatMap groupBy(_.toChar)
	//x groupBy (_)

}