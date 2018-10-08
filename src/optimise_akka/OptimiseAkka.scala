package optimise_akka
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask
import akka.dispatch.ExecutionContexts._
import akka.util.Timeout
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.{Success,Failure}
case class Price(sr:Int,original:Double,min:Double,max:Double,newPrice:Option[Double],result:String)
case class StartOptimising(priceSeq:Seq[Price],digits:Seq[Int])


object OptimiseAkka extends App{

  implicit val ec = global
  override def main(args:Array[String])={
    val priceSeq = Seq(Price(1,67.88,66.67,68.86,None,""),
                       Price(2,76.56,74.90,77.88,None,""),
                       Price(3,89.92,89.90,89.92,None,""))

    val digits = Seq(3,5,9)
    //val newPriceSeq = scala.collection.mutable.MutableList[Price]()
    implicit val timeout = Timeout(15.seconds)
    val system = ActorSystem("Optimise")
    val actor = system.actorOf(Props(new OptimisePriceSeq()),"root_actor")
    val fut = Await.result(actor ? StartOptimising(priceSeq, digits),15.seconds).asInstanceOf[Seq[Price]].sortBy(_.sr)
    println(fut)
    //val ls = fut.sortWith(_.sr < _.sr)
    //println(ls)
    //val fut = actor ? StartOptimising(priceSeq, digits)
    /*fut.andThen{
      case Success(res) => println(res)
      case Failure(res) => println(res)
    }*/
    

    /*fut.andThen{
      case  => println(res)
    }*/

  }
}
