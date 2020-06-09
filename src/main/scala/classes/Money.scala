package classes

object Money {
  def apply(value: Int): Money = new Money(value)
}

class Money(val value: Int = 0) {
  def minus(minus: Int): Unit = {
    this.value - minus
  }
}

object Demo {
  def main(args: Array[String]): Unit = {
    val base = new Money(100)
    val discounted: Unit = base.minus(100)
    println(discounted)
  }
}
