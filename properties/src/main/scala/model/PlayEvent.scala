package model

import model.Entities._

final case class PlayEvent(
    personId: PersonId,
    contentId: ContentId,
    startTime: StartTime
)
