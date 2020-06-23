package services

import model.{PlayEvent, PlayStop, StopEvent}

object CreatePlayStop {

  def createPlayStop(playEvent: PlayEvent, stopEvent: StopEvent) = {
    PlayStop(
      playEvent.personId,
      playEvent.contentId,
      playEvent.startTime,
      stopEvent.stopTime
    )
  }

}
