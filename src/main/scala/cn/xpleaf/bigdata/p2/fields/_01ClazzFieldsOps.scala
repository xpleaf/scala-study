package cn.xpleaf.bigdata.p2.fields

import scala.beans.BeanProperty

/**
  * 在创建scala函数的时候，如果函数空参，我们可以在创建的时候省略掉这个()，
  * 但是访问的时候也就不能使用带()的方式，当然，如果创建的时候没有省略，则两种方式都可以访问
  */
object _01ClazzFieldsOps {
  def main(args: Array[String]): Unit = {
    val person:Person = new Person()
    person.increment()
    println(person.currentAge())
    println(person.currentAge)

/*    val s = new Student
    s.age = 3
    println(s.age)*/
  }

}

class Person {
  private var age:Int = 0

  def increment(): Unit = {
    age += 1
  }


  def currentAge() = age

}

class Student {
  @BeanProperty var age:Int = 0

}

/*class Student {
  private var age:Int = 0

  def setAge(age:Int): Unit = {
    this.age = age
  }

  def getAge() = age

}*/

