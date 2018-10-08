package optimise
object Optimisation {
  case class Price(sr:Int,original:Double,min:Double,max:Double,newPrice:Option[Double],result:String)
  def main(args:Array[String])={
    //as close as possible
    val priceSeq = Seq(Price(1,67.88,66.67,68.86,None,""),
                       Price(2,76.56,74.90,77.88,None,""),
                       Price(3,89.92,89.90,89.92,None,""))

    val digits = Seq(3,5,9)

    //val arr = Array(0.01,0.02,0.03,0.04,0.05,0.06,0.07,0.08,0.09)
    val newPriceSeq = scala.collection.mutable.MutableList[Price]()

    priceSeq.map{ price =>
      var up_bd = "0.0"
      var low_bd = "0.0"
      var flag = false
      var newp = 0.0

      if(price.original >= price.min && price.original <= price.max){
        for(i <- 0 to 9 if flag==false){

          // val orig_s = orig.toString().substring(0,orig.toString.length-1)+""+s(i)
          up_bd = "%.2f".format(price.original + (i+1)*0.01)
          low_bd = "%.2f".format(price.original - (i+1)*0.01)
          //println(up_bd+"   "+low_bd)

          if(digits.contains(low_bd.substring(low_bd.length-1).toInt)) {
            //println("--> "+low_bd.toFloat)
            newp = low_bd.toDouble
            if(newp >= price.min && newp <= price.max)
              flag = true
          }else if(digits.contains(up_bd.substring(up_bd.length-1).toInt)){
            //println("--> "+up_bd.toFloat)
            newp = up_bd.toDouble
            if(newp >= price.min && newp <= price.max)
              flag = true
          }
        }
      }



      flag match {
        case true => newPriceSeq += Price(price.sr,price.original,price.min,price.max,Some(newp),"Optimised")
        case false => newPriceSeq += Price(price.sr,price.original,price.min,price.max,Some(newp),"Not Optimised")
      }

    }

    println("Sr.| Original | Min | Max | New | Result")
    newPriceSeq.foreach{p=>
      println(f"${p.sr} | ${p.original} | ${p.min} | ${p.max} | ${p.newPrice.get} | ${p.result}")
    }

  }
}


