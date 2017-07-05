package objsets.main

import objsets._


object Main extends App {
	val set1 = new Empty
	println(set1)
	val set2 = set1.incl(new Tweet("a", "a body", 20))
	//set2.foreach(res += _)
	println(set2)
	val set3 = set2.incl(new Tweet("b", "b body", 25))
	println(set3)
	val c = new Tweet("c", "c body", 7)
	println(c)
	val d = new Tweet("d", "d body", 9)
	val set4c = set3.incl(c)
	val set4d = set3.incl(d)
	val set5 = set4c.incl(d)
	val set6 = set5.incl(c)
	val set7 = set6.incl(d)
	
	val set8 = set1.filter(tweet => tweet.retweets > 2)
	println(set8)
	
	val set9 = set7.filter(tweet => tweet.retweets > 2)
	//println(set4c.mostRetweeted)
	println(set9)
	
	val x1 = new Empty
	val x2 = x1.incl(new Tweet("a", "a body", 10))
	val x3 = x2.incl(new Tweet("b", "b body", 5))
	val x4 = x3.incl(new Tweet("c", "c body", 20))
	val x5 = x4.incl(new Tweet("d", "d body", 100))
	val x6 = x5.incl(new Tweet("e", "e body", 1))
	println(x6.mostRetweeted)
	println(x1.mostRetweeted)
	
}
