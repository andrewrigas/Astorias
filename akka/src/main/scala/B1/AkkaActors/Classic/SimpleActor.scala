package B1.AkkaActors.Classic

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.Logging

object SimpleActor extends App {

  class MySingleActor extends Actor {
    val log = Logging(context.system, this)

    override def receive: Receive = {
      case "test" =>
        log.info("received test")
      case _      =>
        log.info("received unknown message")
    }
  }

  val actorSystem: ActorSystem = ActorSystem("SingleActorSystem")

  val singleActor = actorSystem.actorOf(Props[MySingleActor], "singleActor")

  singleActor ! "test"
  singleActor ! "dummy"

}
