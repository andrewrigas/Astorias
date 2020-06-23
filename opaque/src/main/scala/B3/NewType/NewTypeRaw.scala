package B3.NewType

import B2.Solution.ValueClass.{Dividend, Divisor, division}
import B3.NewType.NewType.{Dividend, Divisor}

object NewTypeRaw extends App {

  // Generated Code for the NewSubType
  type Dividend = Dividend.Type
  object Dividend {
    type Repr = Double
    type Base = Any { type Dividend$newtype }
    trait Tag extends Any
    type Type <: Base with Tag

    def apply(x: Double): Dividend = x.asInstanceOf[Dividend]

    implicit final class Ops$newtype(val $this$ : Type) extends AnyVal {
      def value: Double = $this$.asInstanceOf[Double]
    }
  }

  // Generated Code for the NewSubType
  type Divisor = Divisor.Type
  object Divisor {
    type Repr = Double
    type Base = Repr { type Divisor$newtype }
    trait Tag extends Any
    type Type <: Base with Tag

    def apply(x: Double): Divisor = x.asInstanceOf[Divisor]

    implicit final class Ops$newtype(val $this$ : Type) extends AnyVal {
      def toDouble: Double = $this$.asInstanceOf[Double]
    }
  }

  private def division(dividend: Dividend, divisor: Divisor): Double = {
    dividend.value / divisor
  }

  val result = division(Dividend(10), Divisor(5))
  //division(Divisor(5),Dividend(10)) Doesn't compile

  println(result)

}
