package WrapArrayIndex


object WrapArrayIndex extends App{

  override def main(args: Array[String])={
    var lst = List[Int]()
    val arr = Array(1,2,3,4,5,6,7,8,9)
    val arr_2 = Array(3,10,6)
    var n=0
    var index =0
    for(i<- 0 to arr_2.length-1){
      if(i==0) {
        n = arr_2(i) - 1
        lst = lst ++ compute(arr, n, 0)
      }
      else {
        index = n+1
        n += (arr_2(i))
        lst = lst ++ compute(arr, n,index)
        if(n > arr.length-1){
          index = 0
          n = (n-index-1)-1
        }
      }
      println("Lst ==>"+lst)
    }
    print(lst)
  }

  def compute(arr_orig:Array[Int],n:Int,index:Int):List[Int]={
    val lst = scala.collection.mutable.MutableList[Int]()
    println("Index==> "+index+" N==> "+n)
    var flag = false
    for(i <- index to n if flag==false){
      lst += arr_orig(i)
      println("I==> "+i)
      if(i==arr_orig.length-1 && n > arr_orig.length-1){
        flag=true
        for(i <- 0 to (n-index-1)-1){
          lst += arr_orig(i)
        }
      }
      /*if(i==n){
        for(c <- n to index by -1){
          println("C==>"+c)
          //println("hhhhhh==>"+arr_orig(c))
          //println("lst========>"+lst)
          lst += arr_orig(c)
        }

      }*/

    }
    lst.toList.reverse
  }
}
