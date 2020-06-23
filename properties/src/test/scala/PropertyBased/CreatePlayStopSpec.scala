package PropertyBased

import Generators.PropertyBaseSpec
import model.{PlayEvent, PlayStop, StopEvent}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import services.CreatePlayStop

class CreatePlayStopSpec extends AnyWordSpec with Matchers with PropertyBaseSpec with ScalaCheckDrivenPropertyChecks {

  "CreatePlayStop" should {
    "create play stop" in {
      forAll { (playEvent: PlayEvent, stopEvent: StopEvent) =>
        CreatePlayStop.createPlayStop(playEvent, stopEvent) shouldBe
          PlayStop(playEvent.personId, playEvent.contentId, playEvent.startTime, stopEvent.stopTime)
      }
    }
  }

}
