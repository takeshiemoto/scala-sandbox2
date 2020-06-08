
// 70点以上ならA1
// 50点以上ならA2
// それ以外はB1


val score = 77
val a1 = 70
val a2 = 50


//if (score >= a1) {
//  println("A1")
//} else if (score >= a2) {
//  println("A2")
//} else {
//  println("B1")
//}

val lank =
  if (score >= a1) "A1"
  else if (score >= a2) "A2"
  else "B2"

println(lank)

