package cn.xpleaf.bigdata.p3

/**
  * 使用object去模拟枚举
  *   枚举，其实说白了就是将一个有限的集合中所有的可能都罗列出来，不用再人为进行输入，就通过
  *   枚举类来完成，规范我们的编程
  *   在java中有专门的枚举这种类型，是和class、interface是并列的，是enum
  *
  *   scala中枚举的类是类名.Value，是因为要继承一个Enumeration的特质，而不像java可以直接定义类的结构enum
  *
  */
object _04EnumOps {
  def main(args: Array[String]): Unit = {
    val red = TrafficLight.RED  // red的类型为：TrafficLight.Value
    println(red)  // RED
    val red1 = TrafficLight.RED1  // 就是本object的引用，如这里，red1的"类型"为：TrafficLight.type，即对TrafficLight的引用
    println(red1) // TrafficLight
  }
}

object TrafficLight extends Enumeration {
//  val RED = TrafficLight;
//  val YELLOW = TrafficLight;
//  val GREEN = TrafficLight;
  val RED, YELLOW, GREEN = Value
  val RED1 = TrafficLight

}
