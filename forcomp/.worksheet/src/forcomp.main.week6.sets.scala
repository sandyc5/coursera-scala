package forcomp.main.week6

object sets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(137); 
  // A set is written analogously to a sequence
  
  val fruit = Set("apple", "banana", "pear");System.out.println("""fruit  : scala.collection.immutable.Set[String] = """ + $show(fruit ));$skip(25); 
  val s = (1 to 6).toSet;System.out.println("""s  : scala.collection.immutable.Set[Int] = """ + $show(s ));$skip(19); val res$0 = 
  
  s map (_ + 2);System.out.println("""res0: scala.collection.immutable.Set[Int] = """ + $show(res$0));$skip(37); val res$1 = 
  fruit filter (_.startsWith("app"));System.out.println("""res1: scala.collection.immutable.Set[String] = """ + $show(res$1));$skip(13); val res$2 = 
  s.nonEmpty;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(220); val res$3 = 
  
  /**
  * NOTES
  * The principal differences b/w sets and sequences are:
  * 1. Sets are unordered
  * 2. Sets do not have duplicate elements
  * 3. Fundamental operation on sets is contains
  */
  
  s map( _ / 2 );System.out.println("""res3: scala.collection.immutable.Set[Int] = """ + $show(res$3));$skip(18); val res$4 = 
  
  s contains 5;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(22); 
  
  val l = (1 to 6);System.out.println("""l  : scala.collection.immutable.Range.Inclusive = """ + $show(l ));$skip(20); val res$5 = 
  
  l map ( _ / 2);System.out.println("""res5: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$5));$skip(1589); 
  
  /**
  * Example: N-Queens
  * The eight queenss problem is to place eight queens on a chessboard so that no queens is threatened by another.
  * In other words, there can't be two queens in the same row, column, or diagonal.
  * We now develop a solution for a chessboard of any size, not just 8.
  * One way to solve the problem is to place a queen on each row.
  * Once we have placed k - 1 queens, one must place the kth queen in a column where it's not "in check" with any other queen on the board.
  *
  * Algorithm
  * We can solve this problem with a recursive algorithm
  * * Suppose that we have already generated all the solutions consisting of placing k - 1 queens on a board of size n
  * * Each solution is represented by a list (of length k -1) containing the numbers of columns ( b/w 0 and n - 1)
  * * The column number of the queen in the k-1th row comes first in the list, followed by the column number of the queen on row k-2 etc
  * * The solution set is thus represented as a set of lists, with one element for each solution
  * * Now, to place the kth queen, we generate all possible extensions of each solution preceded by a new queen
  *
  *
  *  0 1 2 3
  *  _ _ _ _
  * |_|@|_|_| 0
  * |_|_|_|@| 1
  * |@|_|_|_| 2
  * |_|_|@|_| 1
  *
  * List(0, 3, 1)
  * List(2, 0, 3, 1)
  */
  
  def queens(n: Int) : Set[List[Int]] = {
   def placeQueens(k:Int): Set[List[Int]] = {
    if (k == 0) Set(List())
    else
    	for {
    		queens <- placeQueens(k - 1)
    		col <- 0 until n
    		if isSafe(col, queens)
    	} yield col :: queens
   }
   placeQueens(n)
  };System.out.println("""queens: (n: Int)Set[List[Int]]""");$skip(577); 
  
  /**
  * Exercise: Write a function
  * def isSafe(col: Int, queens: List[Int]): Boolean
  * which tests if a queen in an indicatede column col is secure amongst the other placed queens.
  * It is assumed that the new queen is placed in the next available row after the other placed queens
  * (in other words: in row queens.length)
  */
  
  def isSafe(col: Int, queens: List[Int]): Boolean = {
   val row = queens.length
   val queensWithRow = ( row - 1 to 0 by -1) zip queens
   queensWithRow forall {
    case (r, c) => col != c && math.abs(col -c) != row - r
   }
  };System.out.println("""isSafe: (col: Int, queens: List[Int])Boolean""");$skip(188); 
  
  def show(queens: List[Int]) = {
   val lines =
   	for (col <- queens.reverse) yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
   	"\n" + (lines mkString "\n")
  };System.out.println("""show: (queens: List[Int])String""");$skip(24); val res$6 = 
  
  queens(4) map show;System.out.println("""res6: scala.collection.immutable.Set[String] = """ + $show(res$6));$skip(40); val res$7 = 
  
  (queens(4) map show) mkString "\n";System.out.println("""res7: String = """ + $show(res$7));$skip(47); val res$8 = 
  
  (queens(8) take 3 map show) mkString "\n";System.out.println("""res8: String = """ + $show(res$8))}
}
