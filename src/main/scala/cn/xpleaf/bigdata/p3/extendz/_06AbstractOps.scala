package cn.xpleaf.bigdata.p3.extendz

/**
  * scala中的抽象
  *     抽象的字段，就是只有字段定义，没有字段初始化的字段
  *     当一个类中的字段为抽象字段的话，该类要么abstract，要么实现继承一个含有对应抽象字段的类
  *
  *     多态的应用时：
  *     抽象的字段被定义为val，则只能读，不能写（一旦初始化，不能修改）
  *         子类也只能覆盖为val
  *     抽象字段被定义为var，是普通变量
  *         子类可以覆盖为var，也可以覆盖为val
  *         但是如果覆盖为val的话，只能读不能修改
  */
object _06AbstractOps {
  def main(args: Array[String]): Unit = {
    val p:AbsPerson = new ZiPerson
    println("age: " + p.age)
    println("name: " + p.name)
  }
}

abstract class AbsPerson {
  val age:Int
  var name:String
}

class ZiPerson extends AbsPerson {
  val age: Int = 10
  var name: String = "张三"
}

