package cn.xpleaf.bigdata.p3

/**
  * scala中的伴生对象和伴生类
  *   因为scala的语法结构中没有像java中的类，既可以拥有静态方法，也可以有非静态方法，
  *   所以就弄出这么一种结构，和该类class同名的object，并且该class与其同名的object必须要放在同一个.scala文件中
  *   那么我们把这个object称之为同名class的伴生对象
  *   把该class称之为同名object的伴生类
  *
  *   其实我们之前学习的数组Array，Map等的创建都用到了其对应的伴生对象的操作方式。
  *     既可以使用类来创建对象，也可以用伴生对象来创建对象
  *     二者唯一差别在于使用伴生类创建对象，必须要有new，而使用伴生对象来创建对象，直接省去new
  *
  *     在伴生类和伴生对象中可以互相访问对方的成员
  *         要想让伴生对象创建的对象也能访问伴生类中的公开成员，必须要在伴生对象中复写一个方法，apply
  *             返回值为该伴生类的对象（细节：在使用伴生对象创建对象的时候，必须要加()，apply方法也要加()）
  *
  *     如果一个class有伴生的object对象，那么这个class有多少个构造函数，object就要定义多少个apply函数，
  *     apply参数列表同构造函数的参数列表
  */
object _02CompanionObjOps {

  def main(args: Array[String]): Unit = {
    var arr1 = new Array[Int](3)  // 伴生类方式
    var arr2 = Array[Int](4)      // 伴生对象方式
    /**
      * 所以可以知道，前面使用Array或者Map时，之所以用new行，不用new也行，是因为其使用了伴生类和伴生对象的思想
      */

    val p = new Person

    val p1 = new Person()
    println(p1.getAge)
    // 复杂构造
    val p2 = Person("张三", 14)
    println(p2.getAge)

    val p3 = Person("王五")
    println(p3.getAge)

    Person.show
    // p3.show  // 该方法被定义在object中，不能这样进行调用
  }

}

class Person {

  private var name:String = _
  private var age = 5

  def this(name:String, age:Int) {
    this()
    this.name = name
    this.age = age
  }

  def this(name:String) {
    this()
    this.name = name
  }

  def setAge(age:Int): Unit = {
    this.age = age
  }

  def getAge = age

}

object Person {

  def show() = println("person")  // 相当于模拟java中一个类的静态方法，不同的是，需要使用Person.show来调用，而不可以使用p3.show来调用

  def apply(): Person = new Person()

  def apply(name:String, age:Int): Person = new Person(name, age)

  def apply(name: String): Person = new Person(name)
}
