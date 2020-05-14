/**
 * - Seqの作成
 * - SeqはSeqからList型のインスタンスが生成された
 *  - ListはSeqの実装の１つだから
 * */
Seq("A", "B", "C") // Seq[String] = List(A, B, C)


/**
 * Seqの要素へのアクセス
 * seq(index) 要素の取得
 * seq.head: 先頭の値
 * seq.last: 最後の値
 * seq.tail: 先頭以外
 * seq.init: 末尾以外
 * */
val s = Seq("A", "B", "C")

s.apply(1) // res1: String = B
s.apply(2) // res1: String = C

s.head // String = A
s(1) // String = B
s(2) // String = C
s.last // String = C

s.tail // List(B, C)
s.init // List(A, B)

/**
 * 要素数0の場合
 * - 例外が発生する
 * - 要素数がわからないSeq型の値を例外なく取得したい
 *  - headOption・lastOptionを利用する
 *   - ある: Option[A]
 *   - ない: Some
 * */
val s2 = Seq("1", "2", "3")
s2.headOption // Some(1)
s2.lastOption // Some(3)

val emptySeq = Seq()
emptySeq.headOption // None
emptySeq.lastOption // None

/**
 * 要素の追加・削除
 * - 実際の要素は変更されず、新しいSeqが返される
 * - 非破壊
 * */
val s3 = Seq(1, 2)

// 先頭に追加
10 +: s3 // List(10, 1, 2)
// 末尾に追加
s3 :+ 10 // List(1, 2, 10)

// Scalaでは+等の演算子はメソッド呼び出し
1 + 2
1.+(2)

// 下記は同義
s3 :+ 10
s3.:+(10)

// :で終わる演算子は右結合になる
10 +: s3
s3.:+(10)


/** Seq同士の結合 */
val s4 = Seq(1, 2)
val s5 = Seq(3, 4)
s4 ++ s5 // Seq[Int] = List(1, 2, 3, 4)

/** Seqを先頭から個数を指定して要素を取り出す*/
val s6: Seq[String] = Seq("H", "E", "L", "L", "O")
s6.take(1)
s6.take(3)
s6.take(5)

/** Seqを末尾から個数を指定して取り出す */
s6.takeRight(1)
s6.takeRight(3)
s6.takeRight(5)

/** 条件を満たすまで取り出す */
s6.takeWhile(_ == "L")
