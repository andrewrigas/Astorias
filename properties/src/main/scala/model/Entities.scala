package model

import java.time.OffsetDateTime

object Entities {

  abstract class EventEntity[T] {
    def value: T
  }

  final case class PersonId(value: String) extends EventEntity[String]

  final case class ContentId(value: String) extends EventEntity[String]

  final case class StartTime(value: OffsetDateTime) extends EventEntity[OffsetDateTime]

  final case class StopTime(value: OffsetDateTime) extends EventEntity[OffsetDateTime]

}
