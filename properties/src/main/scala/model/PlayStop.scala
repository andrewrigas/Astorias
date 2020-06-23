package model

import model.Entities._

final case class PlayStop(
    personId: PersonId,
    contentId: ContentId,
    startTime: StartTime,
    stopTime: StopTime
)
