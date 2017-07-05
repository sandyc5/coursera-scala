package funsets

import common._


/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
  
  def isNegative(elem: Int): Boolean = {
    def checkIsNegative(s:Set, elem: Int): Boolean = {
      s(elem)
    }
    checkIsNegative(x => x < 0, elem)
  }

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = {
     x => x == elem
  }
 /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = {
    x=> contains(s, x) || contains(t, x) 
  }

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = {
    x=> contains(s, x) && contains(t, x)
  }

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = {
    x=> contains(s, x) && !contains(t, x)
  }
  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = {
    intersect(s, x=> p(x))
  }

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (contains(s, a) && !p(a)) false 
      else iter(a+1)
    }
    iter(-bound)
  }

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) false
      else if (contains(s, a) && p(a)) true 
      else iter(a+1)
    }
    iter(-bound)
  }
  /*
  def exists(s: Set, p: Int => Boolean): Boolean = {
    if (forall(s, x=>p(x))) {
      false
    }
    else true
  }*/

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: Set, f: Int => Int): Set = {
    def iter(a: Int, acc:Set): Set = {
      if (a > bound) acc
      else if (contains(s, a)) iter(a+1, union(acc, singletonSet(f(a))))
      else iter(a+1, acc)
    }
    iter(-bound, x=>false)
  }

  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}