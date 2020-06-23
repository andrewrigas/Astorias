package B2.Solution

object ValueClass extends App {

  //Value Classes can only be extended with Universal Traits
  //Universal Traits are the traits extends with Any
  trait Printable extends Any {
    def print: Unit = println(this)
  }

  class Dividend(val value: Double) extends AnyVal with Printable

  object Dividend {
    def apply(value: Double): Dividend = new Dividend(value)
  }

  class Divisor(val value: Double) extends AnyVal with Printable

  object Divisor {
    def apply(value: Double): Divisor = new Divisor(value)
  }

  private def division(dividend: Dividend, divisor: Divisor): Double = {
    dividend.value / divisor.value
  }

  val result = division(Dividend(10), Divisor(5))
  //division(Divisor(5),Dividend(10)) Doesn't compile

  println(result)

}
