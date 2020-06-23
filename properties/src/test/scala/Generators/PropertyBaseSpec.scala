package Generators

import java.time.OffsetDateTime

import model.Entities._
import model.{PlayEvent, StopEvent}
import org.scalacheck.{Arbitrary, Gen}

trait PropertyBaseSpec {

  implicit val arbContentId = Arbitrary {
    Gen.alphaStr.map(ContentId)
  }

  implicit val arbPersonId = Arbitrary {
    Gen.alphaStr.map(PersonId)
  }

  implicit val arbStartTime = Arbitrary {
    Gen.lzy(OffsetDateTime.now()).map(StartTime)
  }

  implicit val arbStopTime = Arbitrary {
    Gen.lzy(OffsetDateTime.now()).map(StopTime)
  }

  implicit val arbPlayEvent = Arbitrary {
    Gen.resultOf(PlayEvent)
  }

  implicit val arbStopEvent = Arbitrary {
    Gen.resultOf(StopEvent)
  }
}
