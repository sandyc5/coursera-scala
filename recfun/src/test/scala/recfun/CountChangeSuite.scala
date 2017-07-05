package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {
  import Main.countChange
  test("countChange: example given in instructions") {
    assert(countChange(4,List(1,2)) === 3)
  }

  test("countChange: sorted CHF") {
    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(countChange(301,List(5,10,20,50,100,200,500)) === 0)
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }
  
  test("countChange: change for 15") {
    assert(countChange(15,List(5,1,10)) === 6)
  }
  
  test("countChange: change for 15 with 25 coin") {
    assert(countChange(15,List(25, 5,1,10)) === 6)
  }

  test("countChange: degenerate case where money is 0") {
    assert(countChange(0,List(25, 5,1,10)) === 1)
  }
  
  test("countChange: degenerate case where no coins") {
    assert(countChange(15,List()) === 0)
  }
  
  test("countChange: degenerate case where coin is -1") {
    assert(countChange(15,List(-1)) === 0)
  }  

  test("countChange: degenerate case where amount is 1") {
    assert(countChange(1,List(1)) === 1)
  }   
}
