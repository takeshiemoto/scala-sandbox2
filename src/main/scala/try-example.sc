import scala.util.Try

/**
 * Tryの値を作る
 * - Try
 *  - Success
 *  - Failure
 *  - Throwable
 **/

def div(a: Int, b: Int): Try[Int] = Try(a / b)

div(9, 3) // Success(3)
div(10, 0) // Failure(java.lang.ArithmeticException: / by zero)

// 値の利用
div(10, 3).foreach(println) // 3
div(10, 0).foreach(println) // 出力されない

div(10, 3).failed.foreach(println) // 出力されない
div(10, 0).failed.foreach(println) // java.lang.ArithmeticException: / by zero

// 値を変換
div(10, 3).map(_ * 3) // scala.util.Try[Int] = Success(9)
div(10, 0).map(_ * 3) // scala.util.Try[Int] = Failure(java.lang.ArithmeticException: / by zero)
div(10, 3).flatMap(i => div(12, i)) // scala.util.Try[Int] = Success(4)
div(10, 0).flatMap(i => div(12, i)) // Failure(java.lang.ArithmeticException: / by zero)

/**
 * TryCatchのように使う
 * - recover
 * - recoverWith
 */
// 値を返す場合はrecover
div(10, 0).recover {
  case e: ArithmeticException => 0 // scala.util.Try[Int] = Success(0)
}

// Tryを帰す場合はrecoverWith
div(10, 0).recoverWith {
  case e: ArithmeticException => Try(1 + 1) // scala.util.Try[Int] = Success(2)
}

/**
 * 値を取り出す
 * - getOrElse
 * */
div(10, 3).getOrElse(-1) // Int = 3
div(10, 0).getOrElse(-1) // Int = -1




