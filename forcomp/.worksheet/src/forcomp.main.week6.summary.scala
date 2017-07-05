package forcomp.main.week6

import common._
import forcomp._
import scala.io.Source


object summary {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(789); 
  /**
  * Task
  *
	* Phone keys have mnemonics assigned to them.
	* val mnemonics = Map(
	* ’2’ -> ”ABC”, ’3’ -> ”DEF”, ’4’ -> ”GHI”, ’5’ -> ”JKL”,
	* ’6’ -> ”MNO”, ’7’ -> ”PQRS”, ’8’ -> ”TUV”, ’9’ -> ”WXYZ”)
	*
	* Assume you are given a dictionary words as a list of words.
	* Design a method translate such that
	*
	* translate(phoneNumber)
	*
	* produces all phrases of words that can serve as mnemonics for the
	* phone number.
	*
	* Example: The phone number “7225247386” should have the
	* mnemonic 'Scala is fun' as one element of the set of solution
	* phrases
  */
  val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt");System.out.println("""in  : scala.io.BufferedSource = """ + $show(in ));$skip(30); 
  
  val in2 = loadDictionary;System.out.println("""in2  : List[String] = """ + $show(in2 ));$skip(23); 
  
  val wordsIn = in2;System.out.println("""wordsIn  : List[String] = """ + $show(wordsIn ));$skip(73); 
  val words = wordsIn filter (word => word forall (chr => chr.isLetter));System.out.println("""words  : List[String] = """ + $show(words ));$skip(132); 

	val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
	'6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ");System.out.println("""mnem  : scala.collection.immutable.Map[Char,String] = """ + $show(mnem ));$skip(175); 
	
	/** Invert the mnem map to give a map from chars 'A' ... 'Z' to '2' ... '9' */
	val charCode: Map[Char, Char] =
		for ((digit, str) <- mnem; ltr <- str) yield ltr -> digit;System.out.println("""charCode  : Map[Char,Char] = """ + $show(charCode ));$skip(155); 
  
  /** Maps a word to the digit string it can represent, eg "Java" -> "5282"  */
  def wordCode(word: String): String =
  	word.toUpperCase map charCode;System.out.println("""wordCode: (word: String)String""");$skip(22); val res$0 = 
  
  wordCode("Java");System.out.println("""res0: String = """ + $show(res$0));$skip(288); 
  
  /** A map from digit strings to the words that represent them,
  * eg "5282" -> List("Java", "Kata", "Lava", ...)
  * Note: A missing number map to the empty set, eg "1111" -> List()
  */
  val wordsForNum: Map[String, Seq[String]] =
  	words groupBy wordCode withDefaultValue Seq();System.out.println("""wordsForNum  : Map[String,Seq[String]] = """ + $show(wordsForNum ));$skip(323); 
  
  /** Return all ways to encode a number as a list of word */
  def encode(number: String): Set[List[String]] =
  	if (number.isEmpty) Set(List())
  	else {
  		for {
  			split <- 1 to number.length
  			word <- wordsForNum(number take split)
  			rest <- encode(number drop split)
  		} yield word :: rest
  		}.toSet;System.out.println("""encode: (number: String)Set[List[String]]""");$skip(26); val res$1 = 
  
  encode("7225247386");System.out.println("""res1: Set[List[String]] = """ + $show(res$1));$skip(88); 
  
  def translate(number: String): Set[String] =
  	encode(number).map(_ mkString " ");System.out.println("""translate: (number: String)Set[String]""");$skip(30); val res$2 = 
  	
  translate("7225247386");System.out.println("""res2: Set[String] = """ + $show(res$2))}
  
  
  /** SUMMARY ***
  *
  * The Future
  *
  * Scala’s immutable collections are:
  * ▶ easy to use: few steps to do the job.
  * ▶ concise: one word replaces a whole loop.
  * ▶ safe: type checker is really good at catching errors.
  * ▶ fast: collection ops are tuned, can be parallelized.
  * ▶ universal: one vocabulary to work on all kinds of collections.
  * This makes them a very attractive tool for software development
  */
}
