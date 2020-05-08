import java.io.File

val directory = new File("foo") // 存在しないディレクトリ

/** 実行時にnullか否かがわかる */
val files = directory.listFiles() // files: Array[java.io.File] = null

// nullチェックを忘れえると実行時エラー・・・
//println(files.length) // java.lang.NullPointerException

/** Scalaでnullを表すには一般的にOptionを利用する */
def myListFiles(directory: File): Option[Array[File]] = {
  Option(directory.listFiles())
}

// 実行時エラーは回避できる
val myListFile = myListFiles(directory)
// myListFile: Option[Array[java.io.File]] = None

/** Optionの値を作る */
// 値ありはOptionを継承したSomeを返す
Option("Hello") // res0: Option[String] = Some(Hello)
// 値なしはOptionを継承したNoneを返す
Option(null)  // res1: Option[Null] = None

// 利用例: Javaのライブラリはnullを返す事があるのでOptionで処理する
def fileSize(file: File): Option[Long] = {
  if (file.exists()) Option(files.length) else None
}
val size1 = fileSize(new File("README.md")) // res2: Option[Long] = Some(1400)
val size2 = fileSize(new File("angular.json")) // res3: Option[Long] = None

/** Option型の利用 */
// getで取得可能だが、Noneに対してgetすると例外が投げられるので使わない
// size1.get
// java.util.NoSuchElementException: None.get ...

// foreachを使う
// 値がある時は値を表示、無いときは実行されない
size1.foreach(println)
