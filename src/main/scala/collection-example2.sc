/**
 * 定義系
 **/

// 配列を定義
val members = Seq("John", "Paul", "George", "Ringo")

// 空の配列を定義
val emptySeq = Nil

// 空の配列から作成
val members2 = "John" :: "Paul" :: "George" :: "Ringo" :: Nil

/**
 * 要素の追加
 **/
val teams = Seq("Lions", "Hawks", "Fighters")
// 先頭に追加
"Hawks" :+ teams

// 末尾に追加
teams +: "Marines"

/**
 * 要素の取得
 **/
val languages = Seq("JavaScript", "TypeScript", "Scala", "Go", "Ruby", "Python")
// 先頭を取得
languages.head
// 末尾を取得
languages.last
// 位置を指定して取得
languages(1)
languages(2)
languages(3)
// 先頭以外を取得
languages.tail
// 末尾以外を取得
languages.init
// 先頭から個数を指定して取得
languages.take(3)
// 末尾から個数を指定して取得
languages.takeRight(3)
// 先頭から与えた条件を満たすまで取得
languages.takeWhile(_ == "Scala")
// 先頭から指定した個数を捨てて取得
languages.drop(3)
// 末尾から指定した個数を捨てて取得
languages.dropRight(3)
// 先頭から与えた条件満たすまで捨てて取得
languages.dropWhile(_ == "Scala")

/**
 * 要素の取得（Option型）
 **/
val frontEnd = Seq("Angular", "React", "Vue")
val backEnd = Nil
// 先頭を取得
frontEnd.headOption // Some
backEnd.headOption // None
// 末尾を取得
frontEnd.lastOption // Some
backEnd.lastOption // None
/**
 * 要素の情報を取得
 **/
val books = Seq("Book1", "Book2", "Book3")
// 配列の長さ
books.length
// 配列が空か
books.isEmpty

/**
 * 並び替え
 **/
// 要素を並び替える
val animals = Seq("Lion", "Monkey", "Horse")
animals.sorted
// 用をを逆順に並び替える
animals.reverse

// 順序が事前定義されていない配列を並び替える
// sortBy

/**
 * 変換
 **/
// それぞれを変換し、新しい配列を返す
Seq("Hello", "world", "everyone").map(_.head) // 先頭文字列を取り出してChar型にしている

// 入れ子になったSeqを平にする
Seq(Seq(1, 2), Seq(2, 3), Seq(4, 5)).flatten

/**
 * 畳み込み
 **/
// 初期値を設定して先頭から畳み込む
Seq(1, 2, 3).foldLeft(4)((accumulator, element) => accumulator + element)

// 初期値を設定して末尾から畳み込む
Seq(1, 2, 3).foldRight(4)((accumulator, element) => accumulator + element)

// 要素の先頭を初期として先頭から畳み込む
Seq(1, 2, 3).reduceLeft(_ + _)

// 要素の末尾を初期として先頭から畳み込む
Seq(1, 2, 3).reduceRight(_ + _)


/**
 * 型変換
 **/
// Setに変換する
Seq(1, 1, 2, 2, 3, 3, 4, 4, 5, 5).toSet
// Mapに変換する
Seq("Hello" -> 1, "world" -> 2).toMap

/**
 * 可変なSeqに対する操作
 **/
import scala.collection.mutable
val s = mutable.Seq(1, 2)
s.updated(1, 3)
s(2) = 4









