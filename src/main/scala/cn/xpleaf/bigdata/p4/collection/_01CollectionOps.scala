package cn.xpleaf.bigdata.p4.collection

object _01CollectionOps {
  def main(args: Array[String]): Unit = {
    collectionOps1
  }

  // list
  def collectionOps1: Unit = {
    val list = List(1, 2, 3, 4, 5)

    // 练习，利用递归函数，求出该list的sum
    scala.collection.mutable.LinkedHashSet

    val sum = recursion(list)
    println(sum)
  }

  def recursion(list:List[Int]):Int = {
    if(list.isEmpty) {
      return 0  // 使用return显式结束程序的运行，否则0只是该if语句的返回值，并不会结束程序的运行，当然如果用else不用return也行
    }
    list.head + recursion(list.tail)
  }
}
