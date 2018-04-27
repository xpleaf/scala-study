package cn.xpleaf.bigdata.p3

/**
  * scala模拟单例
  */
object _01SingletonOps {
  def main(args: Array[String]): Unit = {
    val s1 = Singleton
    val s2 = Singleton
    s1.incrementAge()
    println("s1's age is: " + s1.getAge)
    println("s2's age is: " + s2.getAge)

    println("=================================")

    println("s1's price is: " + s1.getPhone.getPrice)
    println("s2's price is: " + s2.getPhone.getPrice)
    println("s1 incrementPrice...")
    s1.getPhone.incrementPrice(500.0)
    println("s1's price is: " + s1.getPhone.getPrice)
    println("s2's price is: " + s2.getPhone.getPrice)
  }
}

/**
  * 因为scala中没有静态字段之类，所以我们只能使用static去模拟静态
  * 当被定义为object的类型，其中的所有程序都可以当作java中的静态成员去对待
  * 直接可以通过类名.去调用
  */
object Singleton {
  private var age = 5
  private var phone:Phone = new Phone

  def incrementAge(): Unit = {
    age += 1
  }

  def getAge = age

  def getPhone = phone
}

class Phone {

  var price:Double = 1000.0

  def incrementPrice(addPrice:Double): Unit = {
    this.price += price
  }

  def getPrice = price

}
