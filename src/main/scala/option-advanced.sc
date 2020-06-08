val students = Map(
  "taro" -> Map("数" -> 78, "英" -> 98),
  "jiro" -> Map("社" -> 85, "国" -> 81, "英" -> 69),
  "hana" -> Map("国" -> 98, "英" -> 78),
)

/**
 * 国・英を受講した生徒についてだけ
 * その平均値を標準出力をする
 **/

// v1
//def average(name: String, score: Map[String, Int]): Option[(String, Int)] =
//  if (score.contains("国") && score.contains("英")) {
//    Some((name, (score("国") + score("英")) / 2))
//  } else {
//    None
//  }

// v2
//def average(name: String, score: Map[String, Int]): Option[(String, Int)] =
//  score.get("国").flatMap(ja => score.get("英").map(en => (name, (ja + en) / 2)))

// v3
//def average(name: String, score: Map[String, Int]): Option[(String, Int)] =
//  for {
//    ja <- score.get("国")
//    en <- score.get("英")
//  } yield (name, (ja + en) / 2)

// v4
//def average(name: String, score: Map[String, Int]): Option[(String, Int)] =
//  for {
//    (ja, en) <- score.get("国") zip score.get("英")
//  } yield (name, (ja + en) / 2)
//
//students.foreach {
//  case (name, score) =>
//    average(name, score).foreach(println)
//}
