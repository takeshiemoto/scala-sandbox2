import scala.collection.mutable

/** 1.クラスの継承 */
abstract class Shape {
  def draw(): Unit = {
    println("不明な図形")
  }
}

class Triangle extends Shape {
  override def draw(): Unit = println("三角形")
}

class Rectangle extends Shape {
  override def draw(): Unit = println("四角形")
}

class UnKnowShape extends Shape

/** 2.トレイト */
trait Namable {
  val name: String

  def display(): Unit = println(name)
}

/** 3.計算の一部を遅らせるlazy */
class Circle(x: Int, y: Int, radius: Int) {
  // Circleを生成する度にareaを計算させるのは無駄
  val area: Double = radius * radius * math.Pi
}

// 改良版
class CircleWithLazy(x: Int, y: Int, radius: Int) {
  lazy val area: Double = {
    println("面積を計算する")
    radius * radius * math.Pi
  }
}

/** 4.ジェネリクスと型パラメータ */
class Cell[A](var value: A) {
  def put(newValue: A): Unit = {
    value = newValue
  }
  def get: A = value
}

/**
 * 暗黙パラメータ
 * ユースケース
 * - Listの値をすべて合計してその値を返すメソッドを定義したい
 */


// Int
def sumInt(list: List[Int]): Int = list.foldLeft(0) {
  (x, y) => x + y
}

// Double
def sumDouble(list: List[Double]): Double = list.foldLeft(0.0) {
  (x, y) => x + y
}

// String
def sumString(list: List[String]): String = list.foldLeft("") {
  (x, y) => x + y
}

/**
 * 問題点
 * - 要素の型が増えると際限なくコードが重複する
 */


// トレイトを使ってコードを共通化する
// 0に相当する値と加算処理が未定のため
trait Adder[T] {
  def zero: T
  def plus(x: T, y: T): T
}

def sum[T](list: List[T])(adder: Adder[T]): T = {
  list.foldLeft(adder.zero){(x, y) => adder.plus(x, y)}
}

// 個別の型に対してAdderを定義
object IntAdder extends Adder[Int] {
  def zero: Int = 0
  def plus(x: Int, y: Int): Int = x + y
}

println(sum(List(1, 2, 3))(IntAdder)) // 6

/**
 * 問題点2
 * - 明示的にIntAdderを渡すのは煩雑
 */

// 暗黙パラメータの導入
def sum2[T](list: List[T])(implicit adder: Adder[T]): T = {
  list.foldLeft(adder.zero){(x, y) => adder.plus(x, y)}
}

implicit object IntAdder2 extends Adder[Int] {
  def zero: Int = 0
  def plus(x: Int, y: Int): Int = x + y
}

// (IntAdderが暗黙的に保管されている！)
sum2(List(1, 2, 3)) // 6


/** 複数のトレイトをmixin */
trait Enumerable[A] {
  def foreach[B](fun: A => B): Unit

  final def filter(p: A => Boolean): List[A] = {
    var members = mutable.Buffer.empty[A]
    foreach{m =>
      if (p(m)) members += m
    }
    members.toList
  }

  final def toList: List[A] = {
    var members = mutable.Buffer.empty[A]
    foreach{ m =>
      members += m
    }
    members.toList
  }
}

// トレイトをmixinした場合は同名のフィールド（name）が必要
// Interfaceと同じ考えでOK
class Employee(val name: String) extends AnyRef with Namable {}

object MyApp {
  def main(args: Array[String]): Unit = {
    // 1
    val t = new Triangle
    t.draw()
    val r = new Rectangle
    r.draw()
    val u = new UnKnowShape
    u.draw()

    // 2
    val employee = new Employee("John")
    employee.display()

    // 3
    val circle = new Circle(120, 160, 200) // area計算
    println(circle.area)

    val circleWithLazy = new CircleWithLazy(120, 160, 200)
    println(circleWithLazy.area) // area計算

    // 4
    val cell = new Cell[String]("Hello scala!")
    println(cell.get)
    cell.put("Hello Go")
    println(cell.get)

    val cell2 = new Cell[Int](100)
    println(cell2.get)
    cell2.put(150)
    println(cell2.get)

  }
}
