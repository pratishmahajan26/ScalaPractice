

object Ean13 {
  def main(args: Array[String]) = {
    //val code = "890685432851"
    val country_code = "890"
    val manufacturer_code = "68543"
    //var product_code = 2852
    var product_code = 1001

    for (j <- 0 until 1000) {
      val code = country_code+manufacturer_code+product_code.toString()
      val code_rev = code.reverse
      var sum = 0
      var check_digit = 0
      for (i <- 0 until code.length) {
        //println(Integer.parseInt(code_rev(i).toString()))
        if (i % 2 == 0) {
          sum += Integer.parseInt(code_rev(i).toString()) * 3
        } else {
          sum += Integer.parseInt(code_rev(i).toString())
        }
      }
      
      if (sum % 10 != 0) {
        check_digit = 10 - sum % 10
      }
      
      //if(check_digit == 0)
        //println("Sum ==> " + sum)
      val code_final = code + check_digit.toString()
      println(code_final)
      product_code += 1
    }

  }

}