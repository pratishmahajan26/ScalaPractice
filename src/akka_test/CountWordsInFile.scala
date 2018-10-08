/*

package akka_test
import scala.concurrent.duration._
import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import akka.pattern.ask

case class Message()
object CountWordsInFile extends App{
  override def main(args: Array[String]) ={
    val system = ActorSystem("System")
    val actor = system.actorOf(Props(new WordCounterActor("WordCounterActor.scala")))
    implicit val timeout = Timeout(25 seconds)
    val future = actor ? StringProcessedMsg
    future.map{ result =>
      println("Total number of words==> "+result)
      system.terminate()
    }

    val system = ActorSystem("")
    val actor = system.actorOf(Props(new MyActor), name="actor")
    system.scheduler.schedule(0 seconds, 5 minutes, actor, Message())
  }
}

class MyActor extends Actor with ActorLogging{
  def receive = {case Message() => println()}
}

*/
