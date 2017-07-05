package streams.week7

object WaterPouring {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(85); 
  val problem = new Pouring(Vector(4,9));System.out.println("""problem  : streams.week7.Pouring = """ + $show(problem ));$skip(16); val res$0 = 
  problem.moves;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Product with Serializable with streams.week7.WaterPouring.problem.Move] = """ + $show(res$0));$skip(40); val res$1 = 
  
  
  problem.pathSets.take(3).toList;System.out.println("""res1: List[Set[streams.week7.WaterPouring.problem.Path]] = """ + $show(res$1));$skip(41); val res$2 = 
  
  problem.solutions(6).take(3).toList;System.out.println("""res2: List[streams.week7.WaterPouring.problem.Path] = """ + $show(res$2))}
  
}
