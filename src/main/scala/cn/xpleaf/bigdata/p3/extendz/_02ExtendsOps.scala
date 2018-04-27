package cn.xpleaf.bigdata.p3.extendz

/**
  * scala继承
  *     scala向父类的构造器传递参数
  * java中多态，
  *   父类引用指向子类对象
  *   Fu zi = new zi();
  * scala中多态的体现
  *   val zi:Fu = new zi()
  *   编译看=的左边，运行要看=的右侧
  */
object _02ExtendsOps {
  def main(args: Array[String]): Unit = {
    val coder:Worker = new Coder("xpleaf", 23, "scala")
    coder.show()
  }
}

class Worker(name:String, age:Int) {

  var language:String = _

  def show(): Unit = {
    println(s"name is $name,, and age is $age")
  }

}

class Coder(name:String, age:Int, language:String) extends Worker(name, age) {

  def this() {
    this("程序员", 18, "Java")
  }

  override def show(): Unit = {
    println(s"name is $name, and age is $age, language is $language")
  }

}