package streams.week7

object IntSetsWS {
  
	abstract class IntSet {
		def incl(x: Int): IntSet
		def contains(x: Int): Boolean
	}
	
	case class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
		def contains(x: Int):  Boolean =
			if (x < elem) left contains x
			else if (x > elem) right contains x
			else true
			
		def incl(x: Int): IntSet =
			if (x < elem) NonEmpty(elem, left incl x, right)
			else if (x > elem) NonEmpty(elem, left, right incl x)
			else this
	}
	
	object Empty extends IntSet {
		def contains(x: Int): Boolean = false
		def incl(x:Int): IntSet = NonEmpty(x, Empty, Empty)
	}
	
	/**
	* Laws of IntSet
	* For any set s, and elements x and y:
	*
	* Empty contains x = false
	* (s incl x) contains x = true
	* (s incl x) contains y = s contains y if x != y
	*
	* Proposition 2: Proof by structural induction on s
	* Base case: Empty
	* 	(Empty incl x) contains x
	*
	* Case 1: z = x
	* Induction step: NonEmpty(x, l, r) where y = x
	*
	* NonEmpty(y, l, r)
	*
	* (NonEmpty(x, l, r) incl x) contains x
	* = NonEmpty(x, l, r) contains x  // by definition of NonEmpty.incl
	* = true
	*
	* Case 2: z != x
	* Induction step: NonEmpty(y, l, r) where y < x
	*
	* (NonEmpty(y, l, r) incl x) contains x
	* = NonEmpty(y, l, r incl x) contains x  // by definition of NonEmpty.incl
	* = (r incl x) contains x								// by definition of NonEmpty.contains
	* = true 																// by the induction hypothesis
	*
	* Induction step: NonEmpty(y, l, r) where y > x	is analogous
	*/
}
