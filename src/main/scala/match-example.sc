val signal = "red"

val result = signal match {
  case "red" => "strop"
  case "blue" | "green" => "go"
  case "yellow" => "caution"
//  case _ => "No Match"
  case other => s"error signal $other"
}

println(result)
