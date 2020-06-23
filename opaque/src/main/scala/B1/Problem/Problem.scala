package B1.Problem

object Problem extends App {

  def division(dividend: Double, divisor: Double): Double = {
    dividend / divisor
  }

  val dividend = 10
  val divisor = 5

  val correct = division(dividend, divisor)
  val wrong = division(divisor, dividend)

  println(correct)
  println(wrong)
}
