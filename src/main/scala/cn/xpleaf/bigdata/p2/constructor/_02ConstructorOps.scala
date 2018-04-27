package cn.xpleaf.bigdata.p2.constructor

/**
  * scala中的类的构造器说明
  *   scala类的构造器分为主构造器和辅助构造器
  *   其构造方式不同于java中的构造方式，public 类名(参数列表){},在scala中的构造器如何定义？
  * scala中把类名后面的一对{}括起来的内容称为主构造器的函数体，默认的主构造器为空参构造器,
  *   如何定义一个有参的主构造器呢？
  *   就在类名后面写上函数的定义即可
  *
  *   当主构造器满足不了我们的需求之后，我们就可以创建更多的辅助构造器来配合我们的业务，辅助构造器如何创建？
  *   def this  // 辅助构造器的函数名是this
  *   注意，在辅助构造中的第一句话，必须是调用该类的主构造器或者其他辅助构造器，this(参数)
  *
  *   在一个类中只能有一个主构造器，可以有若干辅助构造器，在辅助构造器的第一句话，调用this
  *
  */
object _02ConstructorOps {
  def main(args: Array[String]): Unit = {
    val p = new Person
    // p.show()
    println("=================================")
    val stu = new Student("前向刘", 17)
    stu.show()
    println("=================================")
    val s = new Student
    println("=================================")
    val s1 = new Student(true)
  }
}

class Person {
  private var name:String = "刘向前"
  private var age:Int = 18

/*  def Person(n:String, a:Int): Unit = {
    name = n
    age = a
    println("这是scala中的构造器吗？")
  }

  def Person(): Unit = {
    println("这是scala中的构造器吗？")
  }*/

  println("这是scala中的构造器吗？")

  def show() = println(s"name is $name and age is $age")
}

class Student(var name:String, var age:Int) {

  def this() {
    this("刘银鹏", 25)
    println("this is 辅助构造器")
  }

  private  var married:Boolean = false
  def this(isMarried:Boolean) {
    this()
    married = isMarried
    println(s"this($isMarried) 是另外一个构造器")
  }

  println("这是scala中的构造器吗？")
  def show() = println(s"name is $name and age is $age")
  // show() // 类构造时就会执行该方法，属性name和age也是默认有的，因为在主构造器中有
}
