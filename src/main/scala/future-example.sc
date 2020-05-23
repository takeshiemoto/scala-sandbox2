import scala.io._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

// 同期API
object HttpTextClient {
  def get(url: String): BufferedSource = Source.fromURL(url)
}

// Futureって？
// Future.applyに渡した式を非同期に評価
// 評価値をFuture型でくるんで返す

val responseFuture: Future[BufferedSource] = Future(HttpTextClient.get("https://www.yahoo.co.jp/"))

// コールバックを登録する
// コールバック is 何
// 完了のタイミングで呼び出される関数


val failedFuture = Future(HttpTextClient.get("https://www.yahoo.co.jp/"))

failedFuture.onComplete {
  case Success(body) =>
    println(body.mkString)
    body.close()
  case Failure(throwable) =>
    println("エラー発生" + throwable.toString)
}
