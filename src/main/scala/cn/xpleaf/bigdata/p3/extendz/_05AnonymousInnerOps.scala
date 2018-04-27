package cn.xpleaf.bigdata.p3.extendz

/**
  * scala中的匿名内部类
  *   第一：匿名内部类是一个内部类
  *   第二：这个内部类没有名字
  *       没有定义的过程，只在程序运行时临时定义
  *
  *   往往匿名内部类用的时候，该内部类对应的类一般是一个抽象，同时该类中抽象方法一般不超过3个
  *
  *   对于如果只调用一次的类而言，我们一般就可以使用匿名内部类的方式去调用，没有必要创建一个类的定义
  */
object _05AnonymousInnerOps {
  def main(args: Array[String]): Unit = {
    val cat = new Cat
    cat.fetchMouse()
    //
    val jqCat = new Cat() {

      def code() = println(s"$kind\5$color\t正在写代码...")

    }
    jqCat.fetchMouse()
    jqCat.code()

    //
    val outer:Outer = new Outer {
      override def show1(): Unit = {
        println("impl show1")
      }

      override def show2(): Unit = {
        println("impl show2")
      }
    }
    outer.show1()
    outer.show2()

  }
}

class Cat {
  var color:String = "黑猫"
  val eyes:Int = 2
  var name:String = _
  var kind:String = "波斯"

  def fetchMouse() = println(s"$kind, color's $color")
}


abstract class Outer {

  def show1()

  def show2()

}
