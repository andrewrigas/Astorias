package model

import model.Entities._

final case class StopEvent(
    personId: PersonId,
    stopTime: StopTime
)
