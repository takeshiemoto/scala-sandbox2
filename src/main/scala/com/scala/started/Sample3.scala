package com.scala.started

import java.io.File

/**
 * Option型
 * - エラーケースを表すnullをScalaで表現するときOptionを利用する
 */

class Sample3 {
  // エラーケースをOptionで表現するため実行時エラーを回避できる
  def myList(dir: File): Option[Array[File]] = {
    Option(dir.listFiles())
  }

  def someAndNoneExample: Unit = {
    /**
     * Some[A] - 値がある時
     * None - 値がない時
     * */
    println(Option("Hello"))
    println(null)
  }
}
