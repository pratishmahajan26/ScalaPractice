/*
package akka_test
import akka.actor.Actor
case class ProcessStringMsg(string: String)
case class StringProcessedMsg(words: Int)
class StringCounterActor() extends Actor{
  override def receive :Receive = {
    case ProcessStringMsg(string) => {
      val wordsInLine = string.split(" ").length
      sender() ! StringProcessedMsg(wordsInLine)
    }
    case _ => println("Error: message not reognized")
  }
}
*/
