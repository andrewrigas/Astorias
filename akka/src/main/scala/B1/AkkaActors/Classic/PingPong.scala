package B1.AkkaActors.Classic

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object PingPong extends App {

  case object Ping
  case object Pong

  class Pinger extends Actor {
    override def receive: Receive = {
      case Pong =>
        println("Pong")
        sender() ! Ping
    }

  }

  class Ponger(pinger: ActorRef) extends Actor {
    override def receive: Receive = {
      case Ping =>
        println("Ping")
        pinger ! Pong
    }
  }

  implicit val system = ActorSystem("PingPong")

  val pinger = system.actorOf(Props[Pinger], "Pinger")
  val ponger = system.actorOf(Props(new Ponger(pinger)), "Ponger")
  ponger ! Ping
}
