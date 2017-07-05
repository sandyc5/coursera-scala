package common

object Tests {

case class Pos(x: Int, y: Int) {
    /** The position obtained by changing the `x` coordinate by `d` */
    def dx(d: Int) = copy(x = x + d)

    /** The position obtained by changing the `y` coordinate by `d` */
    def dy(d: Int) = copy(y = y + d)
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(426); 


    val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin;System.out.println("""level  : String = """ + $show(level ));$skip(107); 

    lazy val vector: Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*);System.out.println("""vector: => Vector[Vector[Char]]""");$skip(23); val res$0 = 
    
    vector.toList;System.out.println("""res0: List[Vector[Char]] = """ + $show(res$0));$skip(30); 
    
    val c = vector(1)(1);System.out.println("""c  : Char = """ + $show(c ));$skip(35); 
    
    val rowSize = vector.size;System.out.println("""rowSize  : Int = """ + $show(rowSize ));$skip(123); 
    
    
	val map = for {
		i <- 1 until rowSize
		j <- 1 until vector(0).size
		if c == vector(i)(j)
		} yield Pos(i, j);System.out.println("""map  : scala.collection.immutable.IndexedSeq[common.Tests.Pos] = """ + $show(map ));$skip(19); 
  val me =  map(0);System.out.println("""me  : common.Tests.Pos = """ + $show(me ))}
  
    

}
