// for loop

//for (i <- 0 to 5) {
//  println(i)
//}

// duplicate loop

//for (i <- 0 to 3; j <- 0 to 5) {
//  println(s"$i and $j")
//}

// loop and if
//for (i <- 0 to 5; j <- 0 to 10 if i == j) {
//  println(s"Match!! $i $j")
//}

// loop return

//val result = for (i <- 1 to 5) yield s"Hello $i"
//println(result)

// array loop
//val member = Seq("John", "Paul", "George", "Ringo")
//for (i <- member) {
//  println(i)
//}
// array loop return
//val result = for (i <- member) yield s"Hello $i"
//println(result)

// array loop foreach
//val member = Seq("Robert C. Martin", "Andrew Hunt", "Kent beck")
//for (m <- member) println(m)
//member.foreach(m => println(m))
//member.foreach(println)
