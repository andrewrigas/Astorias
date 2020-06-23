package B3.NewType

import io.estatico.newtype.macros._

object NewType extends App {

  @newtype case class Dividend(value: Double)

  @newsubtype case class Divisor(value: Double)

  private def division(dividend: Dividend, divisor: Divisor): Double = {
    dividend.value / divisor
  }

  val result = division(Dividend(10), Divisor(5))
  //division(Divisor(5),Dividend(10)) Doesn't compile

  println(result)
}
