/*
package akka_test
import akka.actor.{Actor,ActorRef,Props}
case class StartProcessFileMsg()
class WordCounterActor(fileName: String) extends Actor{
  private var running = false
  private var totalLines = 0
  private var linesProcessed = 0
  private var result = 0
  private var fileSendser:Option[ActorRef] = None
  def receive:Receive = {
    case StartProcessFileMsg => {
      if(running)
        println("Warning : Duplicate Start Message Received")
      else{
        running = true
        fileSendser = Some(sender())
        import scala.io.Source._
        fromFile(fileName).getLines().foreach{ line =>
          context.actorOf(Props(new StringCounterActor())) ! ProcessStringMsg(line)
          totalLines += 1
        }

      }

    }
    case StringProcessedMsg(words) => {
      result += words
      linesProcessed += 1
      if(linesProcessed == totalLines){
        fileSendser.map(_ ! result)
      }
    }
    case _ => println("Message Not Recognized!")
  }
}
*/
