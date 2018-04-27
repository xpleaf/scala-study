package cn.xpleaf.bigdata.p3.extendz

/**
  * scala中的继承
  *     描述类与类之间的关系，其中继承是一种，反映的是is a这种关系，一个类是另外一种类型
  *     子类通过关键字extends继承了父类的field和method，同时可以自定义对应的field和method
  *
  *     需要注意的是，如果父类中的成员，包括父类被final修饰了，则无法被继承，覆盖
  *     同样的，如果父类成员被private修饰之后，子类也无法继承或是覆盖
  *
  *     当有继承体系的时候，在用子类构造器创建对象的时候，先调用父类的构造器，
  *
  *     子类调用父类成员，如果子类没有重名的，直接成员名，如果有重名的，需要使用super.  --->有重名的，在父类中定义方法，通过super.方法名调用即可
  *     scala中是无法直接调用父类构造器，是间接调用父类构造器，只能是主构造器调用父类的构造器，辅助构造器是不能直接调用父类的构造器
  *     （实际测试是：无法使用super的方式访问父类的字段，可以这样访问父类的方法，另外也没有办法调用父类构造器，不管在哪里
  *       当然现在学得还十分浅显，后面肯定会深究一下
  *     ）
  */
object _01ExtendsOps {
  def main(args: Array[String]): Unit = {
    val stu = new Student("001A")
    stu.show()
  }
}

class Person {

  println("----person primary constructor----")

  var name:String = "张三"
  var age:Int = 0

  def this(name:String, age:Int) {
    this()
    this.name = name
    this.age = age
  }

  /*final*/ def show() = println(s"name is $name, and age is $age")
}

class Student extends Person {

  println("----student primary constructor----")

//  override var name:String = "小红"

  private var cardID:String = _

  def this(cardID:String) {
    this()
    this.cardID = cardID
    println("----student 辅助 constructor----")
  }

  /*
  为啥被final修饰的成员，子类无法覆盖？
  因为final代表的就是常量，代表的就是最终的量，所以不能进行覆盖
  */
  override def show(): Unit = {
    super.show()
    println("name is " + name + s", and age is $age, cardID is $cardID")
  }
}