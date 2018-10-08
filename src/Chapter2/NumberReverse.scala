package Chapter2
import java.lang.Math
import java.math.BigInteger
object NumberReverse {
  def main(args:Array[String])={
    var n = new BigInteger("78976567678898457657687643098902470990099075464")
    var a = new BigInteger("0")
    a=n
    n=new BigInteger("0")
    print("Hello")
    while(!a.equals(new BigInteger("0"))){
      println("Inside==> "+a)
      n = n.add(a.mod(new BigInteger("10")))
      if(!a.divide(new BigInteger("10") ).equals(new BigInteger("0")))
        n = n.multiply(new BigInteger("10"))
      a=a.divide(new BigInteger("10"))
    }

    print("Reverse =>"+n)
  }
}
