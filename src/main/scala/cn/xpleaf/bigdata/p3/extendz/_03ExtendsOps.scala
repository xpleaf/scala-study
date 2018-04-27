package cn.xpleaf.bigdata.p3.extendz

/**
  * 在java中判断对象A是否为B这种类型
  * if(A instanceOf B){
  *
  * }
  * 常见在于equals里面来进行操作
  *   类型检查使用instanceOf，类型转换使用的强制类型转换--->Java
  *   而在scala中：
  *   类型检查：isInstanceOf
  *   类型转换：asInstanceOf
  *
  *   这里书写的这种isInstanceOf也可以使用scala中模式匹配来操作
  */
object _03ExtendsOps {
  def main(args: Array[String]): Unit = {
    // 比较两个工程师是否为同一个人，依据就是姓名是否相等
    val e1 = new Engineer("lisi", 12345)
    val e2 = new Engineer("lisi", 12345)
    println(e1.equals(e2))  // true
    println(e1.getName)     // lisi
    println("======================================")
    // 类型检查的第二种方式，使用模式匹配来进行操作
    val e3:Employee = new Engineer("wangwu", 3457)
    val e4:Employee = new ProductManager

    // 使用模式匹配来确定要执行的方法
    e3 match {
      case e:Engineer => {
        e.code()
      }
      case e:ProductManager => {
        e.pm()
      }
    }
  }
}

class Employee {
  private var name:String = _
  private var salary:Float = _

  def this(name:String, salary:Float) {
    this()
    this.name = name
    this.salary = salary
  }

  def getName = name

  def show: Unit = {
    println(s"$name ======> $salary")
  }
}

class Engineer(name:String, salary:Float) extends Employee {
  private var age:Int = _

  override def getName = name

  def code() = println("Engineer正在写代码...")

  override def equals(obj: scala.Any): Boolean = {
    if(!obj.isInstanceOf[Engineer]) { // 类型检查
      false
    } else {
      // 类型转换
      val o = obj.asInstanceOf[Engineer]
      if(this.getName.equalsIgnoreCase(o.getName)) {
        true
      } else {
        false
      }
    }
  }
}

class ProductManager extends Employee {
  def pm() = println("pm正在赶需求...")
}