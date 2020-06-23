package B1.AkkaActors.Typed

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

object HelloWorldActor {

  trait Command

  case object HelloWorld extends Command

  final case class ActorSender(whom: String, sendTo: ActorRef[ActorReceiver])
  final case class ActorReceiver(whom: String, from: ActorRef[ActorSender])

  def apply(): Behavior[ActorSender] =
    Behaviors.receive { (context, message) =>
      context.log.info(s"Hello ${message.whom}")
      message.sendTo ! ActorReceiver(message.whom, context.self)
      Behaviors.same
    }
}
