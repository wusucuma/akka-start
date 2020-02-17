import akka.actor.{ActorSystem, Props}

object Main extends App {

  val system = ActorSystem("HelloSystem")

  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

  helloActor ! "create"
  helloActor ! "create"
  Thread.sleep(1000)

  helloActor ! "hi"
  Thread.sleep(1000)

  helloActor ! "stop"
  Thread.sleep(1000)

  system.terminate()
}
