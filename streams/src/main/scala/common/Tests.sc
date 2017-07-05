package common

object Tests {

case class Pos(x: Int, y: Int) {
    /** The position obtained by changing the `x` coordinate by `d` */
    def dx(d: Int) = copy(x = x + d)

    /** The position obtained by changing the `y` coordinate by `d` */
    def dy(d: Int) = copy(y = y + d)
  }


    val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin                  //> level  : String = ooo-------
                                                  //| oSoooo----
                                                  //| ooooooooo-
                                                  //| -ooooooooo
                                                  //| -----ooToo
                                                  //| ------ooo-

    lazy val vector: Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*)
                                                  //> vector: => Vector[Vector[Char]]
    
    vector.toList                                 //> res0: List[Vector[Char]] = List(Vector(o, o, o, -, -, -, -, -, -, -), Vector
                                                  //| (o, S, o, o, o, o, -, -, -, -), Vector(o, o, o, o, o, o, o, o, o, -), Vector
                                                  //| (-, o, o, o, o, o, o, o, o, o), Vector(-, -, -, -, -, o, o, T, o, o), Vector
                                                  //| (-, -, -, -, -, -, o, o, o, -))
    
    val c = vector(1)(1)                          //> c  : Char = S
    
    val rowSize = vector.size                     //> rowSize  : Int = 6
    
    
	val map = for {
		i <- 1 until rowSize
		j <- 1 until vector(0).size
		if c == vector(i)(j)
		} yield Pos(i, j)                 //> map  : scala.collection.immutable.IndexedSeq[common.Tests.Pos] = Vector(Pos(
                                                  //| 1,1))
  val me =  map(0)                                //> me  : common.Tests.Pos = Pos(1,1)
  
    

}