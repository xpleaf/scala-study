package cn.xpleaf.bigdata.p3

/**
  * 对象的扩展
  *   只有方法的定义，没有方法体，该方法被称之为抽象方法
  *   定义了抽象方法的类，必须是抽象类
  *   scala中定义的抽象方法可以省略abstract关键字（实际上测试是不能加abstract的）
  *
  * object的另外一个特性，scala中程序的执行都必须要通过main
  * 当然有时候我们可以不用写这个main，只需要继承一个App即可
  */
object ObjectExtendsOps extends App {
  /*def main(args: Array[String]): Unit = {
    ObjAccountImpl.register("xpleaf")

  }*/
  if(args == null || args.length < 2) { // 继承App后，也是可以直接使用args对象的
    println(
      """参数要写正确哦. Usage: <inputPath string> <outputPath string>
        |inputPath:   输入文件路径
        |outputPath:  输出文件路径
      """.stripMargin)
    System.exit(-1)
  }
  println(args(0))
  println(args(1))
  ObjAccountImpl.register("xpleaf")
}

abstract class Account(name:String) {

  def register(name:String)

  def unRegister(name:String)

}

object ObjAccountImpl extends Account("张三") {

  override def register(name: String): Unit = {
    println(name + "注册账号")
  }

  override def unRegister(name: String): Unit = {
    println(name + "注销账号")
  }

}

/**
  * 如果是类继承的话，则可以加上构造器，但是object去继承时就不行
  */
class ObjAccountImpl1(name:String) extends Account(name) {

  override def register(name: String): Unit = {
    println(name + "注册账号")
  }

  override def unRegister(name: String): Unit = {
    println(name + "注销账号")
  }

}
