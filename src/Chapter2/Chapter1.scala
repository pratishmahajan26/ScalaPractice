package chapter2

object Chapter1 {


  def main(args:Array[String]): Unit ={
    val chapter1 = new Chapter1(8)
    println("Max Value =>"+chapter1.max(5,6))
    val (a1,a2,a3) = (1,2,3)
    val str = s"hello ${a1}, ${a2}, ${a3}"
    println(chapter1.whileLoop(args))
    println(chapter1.for_loop(args))

    val n1 = List(1,2,3,4)
    val n2 = List(5,6,7,8)
    println(n1.flatMap(x=> List(x+3)))
    val n3 = n1.flatMap{x=> n2.map(y=> x+y)}
    println(n3)

    val add = Some(addThenMul(5,7,8)((x:Int,y:Int)=>x+y))
    print("Currying==>"+add.map(a=>a+5))
  }

  def addThenMul(z:Int,a:Int,b:Int)(am:(Int,Int)=>Int):Int={
    z * am(a,b)
  }



}



class Chapter1(z:Int) {
  def max(x:Int, y:Int):Int ={
    if(x > y)
      x
    else
      y+z
  }

  def whileLoop(args: Array[String]): Int ={
    var i = 0
    while (i < args.length) {
      if (i != 0)
        print(" ")
      print(args(i))
      i += 1
    }
    println()
    i
  }

  def for_loop(args: Array[String]): Unit ={
    args.foreach((arg:String) => println(arg))
    //args.foreach(arg => print(arg))
    //args.foreach(print)

   /* for(arg <- args){
      println(arg)
    }*/
  }
}


