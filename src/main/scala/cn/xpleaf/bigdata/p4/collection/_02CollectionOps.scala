package cn.xpleaf.bigdata.p4.collection

import scala.collection.mutable.SortedSet

object _02CollectionOps {
  def main(args: Array[String]): Unit = {
    setOps1
  }

  /**
    * 关于scala集合顺序的说明
    *     测试1：按照年龄进行升序，年龄相等，姓名降序
    *     测试2：要按照姓名升序比较，按照年龄升序比较
    * SortedSet在添加普通对象Person之类，报错
    *   No implicit Ordering defined for Person
    *   要想在有序集合中添加元素，必须要让元素具备比较性，要和给集合提供比较器
    *   在java中前者是要类实现Comparator，后者需要给集合提供一个比较器Comparator
    *   在scala中，前者需要让类扩展Ordered的特质，后者给集合传递一个Ordering比较器
    *
    *   当两个比较都实现的话，优先使用集合的比较器
    */
  def setOps1: Unit = {
    var set = SortedSet[Person]()(new Ordering[Person] {
      override def compare(x: Person, y: Person):Int = {
        var ret = x.getName.compareTo(y.getName)
        if(ret == 0) {
          ret = x.getAge.compareTo((y.getAge))
        }
        ret
      }
    })
    set.+= (new Person("王立鹏", 19))
    set.+= (new Person("冯 剑", 18))
    set.+= (new Person("刘银鹏", 15))
    set.+= (new Person("李小小", 19))
    // println(set)
    set.foreach(println(_))
  }
}

class Person extends Ordered[Person] {
  private var name:String = _

  private var age:Int = _

  def this(name:String, age:Int) {
    this()
    this.name = name
    this.age = age
  }

  def getAge = age

  def getName = name

  override def toString: String = {
    s"[$name, $age]"
  }

  /**
    * 按照年龄进行升序，年龄相等，姓名降序
    * 升序：前面比后面
    * 降序：后面比前面
    */
  override def compare(that: Person) = {
    var ret = this.age.compareTo(that.age)
    if(ret == 0) {
      ret = that.name.compareTo(this.name)
    }
    ret
  }
}