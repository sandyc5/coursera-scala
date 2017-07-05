package recfun
import common._
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    
    def loop(acc: Int, c: Int, r: Int): Int = {
	    if ((c == 0) || (c== r) ){
	      acc + 1
	    }
	    else {  
	    	loop(acc, c-1, r-1) + loop(acc, c,r-1)
	    }
    }
    loop(0, c, r)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def checkBalance(balance: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) {
        balance == 0
      }
      else if (chars.head == '(') {
        checkBalance(balance+1, chars.tail)
      }
      else if (chars.head == ')' && balance > 0) {
        checkBalance(balance-1, chars.tail)
      }
      else {
        checkBalance(balance, chars.tail)
      }
    }
    checkBalance(-1, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    
    def count(change: Int, money: Int, coins: List[Int]): Int = {
	    if (money == 0) {
	      change + 1
	    }
	    else if (money < 0) {
	      change + 0
	    }
	    else if ((coins.isEmpty || coins.head <= 0 ) && money >= 1)  {
	      change + 0
	    }
	    else {
	      count(change, money, coins.tail ) + count( change, money - coins.head, coins )
	    }
    }
    
    count(0, money, coins)
  }
  
/*  def count( n, m ):
    if n == 0:
        return 1
    if n < 0:
        return 0
    if m <= 0 and n >= 1: #m < 0 for zero indexed programming languages
        return 0
 
    return count( n, m - 1 ) + count( n - S[m], m )
*/
}