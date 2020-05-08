import java.io.File


/**
 * Either
 * - 正常: Right
 * - 異常: Left
 */
def fileSize(file: File): Either[String, Long] = {
  if (file.exists()) Right(file.length()) else Left("File not exists")
}

/**
 * 値の利用
 * - foreachを利用して取り出す
 * - Rightのみ関数が実行される
 **/
val r: Either[String, Int] = Right(100)
r.foreach(println) // 100
val l: Either[String, Int] = Left("Hello")
l.foreach(println) // 実行されない

// Leftのみ実行する場合
r.left.foreach(println) // 実行されない
l.left.foreach(println) // Hello

// 値を変換
val either: Either[String, Int] = Right(1)
either.map(_ * 2)
either.right.map(_ * 2)
either.left.map(_ + 2)

// Rightがあったとき
val r2: Either[String, Long] = Right(100)
r2.flatMap(l => Right(l * 5)) // 加工
r2.flatMap(_ => Left("Error")) // EitherがLeftを返すと結果はLeftになる

val l2: Either[String, Long] = Left("Error 1")
l2.flatMap(l => Right(l * 5)) // Leftに対してflatMapを呼び出しても変化なし

/**
 * 値を取り出す
 * - getOrElse
 */
Right(1).getOrElse(100) // 100
Left("foo").getOrElse(100) // Leftの場合はgetOrElseの値が表示される 100
