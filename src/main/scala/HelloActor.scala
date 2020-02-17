import akka.actor.{Actor, Props}
import akka.event.Logging

class HelloActor extends Actor {
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case "create" =>
      context.actorOf(Props[ChildActor])
      log.info(s"create child actor - ${context.children}")
    case "hi" =>
      for(c <- context.children)
        c ! "hi"
    case "stop" =>
      log.info("stopping")
      context.stop(self)
    case _ => println("who?")
  }
}
