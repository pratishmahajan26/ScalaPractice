package optimise_akka
import akka.actor.{Actor,Props,ActorRef}

case class Compute(price:Price,digits:Seq[Int])
case class PriceComputationResult(price:Price)
class OptimisePriceSeq extends Actor {
  var length_priceSeq = 0
  var root_actor:Option[ActorRef] = None
  val seq_price = scala.collection.mutable.MutableList[Price]()
  def receive = {
    case StartOptimising(priceSeq,digits) => readPriceSeq(priceSeq,digits)
    case PriceComputationResult(price) => appendPriceSeq(price)
    case _ => println("Invalid Message Received 1")
  }

  def readPriceSeq(priceSeq: Seq[Price],digits: Seq[Int])= {
    length_priceSeq = priceSeq.length
    root_actor = Some(sender)
    priceSeq.map { price =>
      println("AAAAAA=======>"+price)
      context.actorOf(Props(new ComputePrice)) ! Compute(price,digits)
    }
  }

  def appendPriceSeq(price: Price)={
    println("Append ===>"+price)
    seq_price += price
    println(seq_price.length + "   "+length_priceSeq)
    if(seq_price.length == length_priceSeq){
      println("===> "+sender)
      root_actor.map(_ ! seq_price)
    }
  }
}


class ComputePrice extends Actor{


  def receive = {
    case Compute(price,digits) => startComputingPrice(price,digits)
    case _ => println("Invalid Message Received 2")
  }

  def startComputingPrice(price: Price, digits: Seq[Int])={
    var up_bd = 0.0
    var low_bd = 0.0
    var flag = false
    var newp = 0.0

    if(price.original >= price.min && price.original <= price.max){
      for(i <- 0 to 9 if flag==false){

        // val orig_s = orig.toString().substring(0,orig.toString.length-1)+""+s(i)
        up_bd = "%.2f".format(price.original + (i+1)*0.01).toDouble
        low_bd = "%.2f".format(price.original - (i+1)*0.01).toDouble
        //println(up_bd+"   "+low_bd)

        //if(digits.contains(low_bd.substring(low_bd.length-1).toInt)) {
        if(digits.contains((low_bd * 100) % 10)) {
          //println("--> "+low_bd.toFloat)
          newp = low_bd
          flag = true
          //}else if(digits.contains(up_bd.substring(up_bd.length-1).toInt)){
        }else if(digits.contains((up_bd * 100) % 10)){
          //println("--> "+up_bd.toFloat)
          newp = up_bd
          flag = true
        }
      }
    }

    if(newp < price.min || newp > price.max)
      flag = false

    flag match {
      case true => { val p = PriceComputationResult(Price(price.sr,price.original,price.min,price.max,Some(newp),"Optimised"))
        println("=======>"+p)
        sender ! p}
      case false => { val p = PriceComputationResult(Price(price.sr,price.original,price.min,price.max,Some(newp),"Not Optimised"))
        println("========>"+p)
        sender ! p}
    }
  }
}
