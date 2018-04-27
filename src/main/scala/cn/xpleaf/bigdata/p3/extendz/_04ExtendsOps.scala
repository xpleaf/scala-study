package cn.xpleaf.bigdata.p3.extendz

/**
  * scala继承之protected修饰符
  *     1.被protected修饰的成员，子类可以直接访问，其它子类实例可以访问
  *     2.如果在protected后面加上[this]则表示只能在当前子类中访问，不能在其它子类实例中进行访问，即可能在子类的定义中使用，子类对象无法调用
  *     3.如果protected或者private后面[]中的内容不是this，而是其它包名，则说明该字段或者该方法
  *     只能在对应的包目录或者子包中目录结构中能够进行调用
  */
object _04ExtendsOps {
  def main(args: Array[String]): Unit = {
    val wc = new Dog
    val fg = new Dog
    wc.makeDifference(fg)
  }
}

class Animal {

  private[this] var privateThis:Int = 4
  private[extendz] var privatePackage:Int = 4

  protected var leg:Int = 4

  protected[this] var eyes:Int = 2

  protected[extendz] var others:Int = 2

}

class Dog extends Animal {
  private var color:String = "yellow"

  def getEyes:Int = eyes

  def makeDifference(dog:Dog): Unit = {
    println(s"this dog's leg is $leg, that dog's leg is ${dog.leg}") // 可以直接使用dog.leg，因为protected修饰
    println(s"this dogs's eyes is $eyes, that dog's eyes is ${dog.getEyes}")  // 不可以直接使用dog.eyes，因为protected[this]修饰，只能本类或子类使用
    println(s"this dog's others is $others, that dog's others is ${dog.others}")  // others被protected[extendz]修饰，extendz包下的都可以访问
    // println(privateThis) // 不能访问
    println(privatePackage + "\t" + dog.privatePackage) // 可以访问
    // 可以看到scala中的修饰符跟Java的还是有区别的
  }
}
