class Point(val x: Int, val y: Int) {
  def distance(that: Point): Int = {
    val xDiff = math.abs(this.x - that.x)
    val yDiff = math.abs(this.y - that.y)
    math.sqrt(xDiff * xDiff + yDiff * yDiff).toInt
  }

  def +(that: Point): Point = new Point(x + that.x, y + that.y)
}

val p1 = new Point(10, 10)
val p2 = new Point(100, 100)

println(p1.distance(p2))
println(math.abs(p1.x - p2.x))
println(p1 + p2)

abstract class Shape {
  def draw(): Unit = {
    println("不明な図形")
  }
}

class Triangle extends Shape {
  override def draw(): Unit = {
    println("三角形")
  }
}

class Rectangle extends Shape {
  override def draw(): Unit = {
    println("四角形")
  }
}

class UnKnowShape extends Shape

val triangle = new Triangle
triangle.draw()

val rectangle = new Rectangle
rectangle.draw()

val unKnowShape = new UnKnowShape
unKnowShape.draw()



/**
 * トレイトはClassからnewでインスタンスする機能を省いたもの
 * */
trait Nameable {
  val name: String
  def display(): Unit = println(name)
}

class Employee(val name: String) extends AnyRef with Nameable
val john = new Employee("John")
println(john.display())

/**
 * コンパニオンオブジェクト
 * */
class User(val name: String) {
  def sayName(): Unit = println(this.name)
}

object User {
  def apply(name: String) = new User(name)
}

User("John").sayName()
