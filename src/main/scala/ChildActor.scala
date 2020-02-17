import akka.actor.Actor
import akka.event.Logging

class ChildActor extends Actor {
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case "hi" =>
      val parent = context.parent
      log.info(s"$parent made")
  }

  override def postStop(): Unit = {
    log.info("child stop")
  }
}
