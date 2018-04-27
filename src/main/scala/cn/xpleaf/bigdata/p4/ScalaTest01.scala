package cn.xpleaf.bigdata.p4

object ScalaTest01 {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 8, 3, 2, -1, 15)
    sort(arr)
    arr.foreach(println)
  }

  def sort(arr: Array[Int]): Unit = {
    for(i <- 0 until arr.length - 1) {
      for(j <- i + 1 until arr.length) {
        if(arr(j) < arr(i)) {
          swap(arr, i, j)
        }
      }
    }
  }

  def swap(arr: Array[Int], i:Int, j:Int): Unit = {
    arr(i) = arr(i) ^ arr(j)
    arr(j) = arr(i) ^ arr(j)
    arr(i) = arr(i) ^ arr(j)
  }
}
