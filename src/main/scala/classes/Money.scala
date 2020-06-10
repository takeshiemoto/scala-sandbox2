package classes

object Money {
  def getInfo(): Unit = println("Money object")

  def apply(value: Int): Money = new Money(value)
}

class Money(val value: Int) {
  def minus(v: Int) = {
    new Money(this.value - v)
  }
}

object Demo {
  def main(args: Array[String]): Unit = {
    println(Money.getInfo())
    val base = Money(100)
    val discounted = base.minus(50)
    println(discounted)
  }
}
