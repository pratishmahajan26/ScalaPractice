package FunctionalObjects

class RationalObject(n:Int, d:Int) {
  require(d!=0)
  val numen:Int = n
  val denom:Int = d

  //Auxiliary Constructor
  def this(n: Int) = this(n,1)

  override def toString = numen+"/"+denom
  //Throw Error
  /*def add(that: RationalObject):RationalObject ={
    new RationalObject(n*that.d+that.n*d,d*that.d)
  }*/

  def add(that: RationalObject):RationalObject = {
    new RationalObject(numen * that.denom +  that.numen * denom, denom * that.denom)
  }
  //print(n+"/"+d)
  def lessThan(that: RationalObject) = {
    this.numen * that.denom < that.denom * this.numen
  }

  def max(that: RationalObject):RationalObject = {
    if(this.lessThan(that)) that else this
  }

  def gcd(a:Int, b:Int):Int = {
    if (b == 0) {
      println("1st ==> "+a)
      a
    }
    else {
      println(s"2nd ==>$a...$b ")
      gcd(b, a % b)
    }
  }

  def factorial(n:Int):Int = {
    def factWithAccumulator(acc:Int,n:Int):Int = {
      if(n == 1){
        acc
      }else{
        factWithAccumulator(acc*n, n-1)
      }
    }
    factWithAccumulator(1,n)
  }

}

object RationalObject{
  def main(args: Array[String]):Unit = {
   val r =  new RationalObject(5,3)
    //print(r.toString)

    val result = r add new RationalObject(6,7)
    println(result.toString)

    // Calling Auxiliary Constructor
    val aux_cons = new RationalObject(3)
    println("Calling Aux_Cons==>"+aux_cons.toString)

    case class Donut(name:String, price: Double)

    val donut = Seq(Donut("P",1.5),Donut("S",1.7),Donut("F",1.7),Donut("P",1.4))
    val donut_group: Map[String, Seq[Donut]] = donut.groupBy(_.name)
    println(s"Donuts $donut_group")

    //r.gcd(12,18)

    println(s"LCM "+12*18/r.gcd(12,18))

    println(s"Fact==> "+r.factorial(8))
  }
}
