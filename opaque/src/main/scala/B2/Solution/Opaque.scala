package B2.Solution

object Opaque {

  trait DividendTag

  type Dividend = Double with DividendTag

  final implicit class DividendOps(private val dividend: Dividend) {
    def value: Double = dividend.asInstanceOf[Double]
  }

  object Dividend {
    def apply(value: Double): Dividend = value.asInstanceOf[Dividend]

    def unapply(dividend: Dividend): Option[Double] = Option(dividend).map(_.value)
  }

  trait DivisorTag

  type Divisor = Double with DivisorTag

  final implicit class DivisorOps(private val divisor: Divisor) {
    def value: Double = divisor.asInstanceOf[Double]
  }

  object Divisor {
    def apply(value: Double): Divisor = value.asInstanceOf[Divisor]

    def unapply(divisor: Divisor): Option[Double] = Option(divisor).map(_.value)
  }

  def division(dividend: Dividend, divisor: Divisor): Double = {
    dividend / divisor
  }
}
