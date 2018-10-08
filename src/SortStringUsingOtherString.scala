object SortStringUsingOtherString extends App {

  override def main(args:Array[String])={
    val pattern = "bca"
    val to_sort = "adebfgcfz"
    sort_using_other_string(to_sort, pattern)
  }

  def sort_using_other_string(to_sort:String, pattern:String):String={
    val count1 = new Array[Int](to_sort.length())(0)
    val count = Array.fill(26)(0)
    for(i <- 0 until to_sort.length()){
      val pos = to_sort(i) - 'a'
      //count(pos) = count(pos) + 1
      count.update(pos,count(pos)+1)
    }

    val arr = new Array[Char](to_sort.length())
    for(i <- 0 until arr.length){
      arr.update(i,'0')
    }
    println(count.mkString(","))
    //val str = new String(Array.fill(to_sort.length())('0'))
    val str = new String(arr)
    val str_build = new StringBuilder(str)
    println(str)

    var index = 0
    for(i <- 0 until pattern.length()){
      for(j <- 0 until count(pattern(i) - 'a')){
        str_build(i) = pattern(i)
        if(j+1 == count(pattern(i) - 'a')){
          count.update(pattern(i) - 'a', 0)
        }
        index += 1
      }
    }

    var sorted = new StringBuilder(to_sort)

    for(i <- 0 until sorted.length){
      for(j <- i+1 until sorted.length){
        if(sorted(i) > sorted(j)) {
          val temp = sorted(i)
          sorted(i) = sorted(j)
          sorted(j) = temp
        }
      }
    }

    println(str_build)
    for(i <- 0 until count.length){
      if(index < to_sort.length() && count(sorted(i) - 'a') != 0){
        for(j <- 0 until count(sorted(i) - 'a')){
          str_build(index) = sorted(index)
          if(j+1 == count(sorted(i) - 'a')){
            count(sorted(i) - 'a') = 0
          }
          index += 1
        }
      }
    }

    println(str_build)
    to_sort
  }
}
