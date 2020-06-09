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

// array loop and filter
//val numbers = List[Int](1, 2, 3, 4, 5, 6)
//val results = numbers.filter((n) => { n % 3  == 0})
//println(results)
//val result = numbers.filter(n => n % 3 == 0)
//val result = numbers.filter(_ % 3 == 0)

// array loop and filter and map
//val numbers = List[Int](1, 2, 3, 4, 5, 6)
//val result = numbers.filter(_ % 3 == 0).map(_ * 10)
//println(result)
//numbers
//  .filter(_ % 3 == 0)
//  .map(_ * 10)
//  .foreach(println)

// array map with function
//val nums = List(1, 2, 3, 4, 5)
//val isEven: Int => Boolean = _ % 2 == 0
//def isEven(n: Int): Boolean = {
//  n % 2 == 0
//}
//def isEven(n: Int) = n % 2 == 0
//nums.filter(isEven).foreach(println)
