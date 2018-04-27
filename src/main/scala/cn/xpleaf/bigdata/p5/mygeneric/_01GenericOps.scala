package cn.xpleaf.bigdata.p5.mygeneric

/**
  * scala的类型参数，即java中的泛型
  * 定义方式有异，java使用使用<>，scala使用[]
  * 泛型可以定义在类 特质 方法 函数
  * 泛型的作用，就是将运行期间的异常，提前到了编译器
  * 提高代码的通用性
  */
object _01GenericOps {
    def main(args: Array[String]): Unit = {
        //    genericOps1
        //    genericOps2
        genericOps3
    }

    /**
      * 泛型的上界
      * Upper Bound
      * [T <: 类] ---> [T <% 类] （视图的界定）
      */
    def genericOps3: Unit = {
        class Student[T <% Comparable[T]](private val first: T, private val second: T) {
            def bigger():T = {
                /**
                  * 如果要让first和second有compareTo方法，必须要为Comparable的子类或者是Ordered的子类
                  * 说白了也就是要让这个类型参数T是Comparable或者Ordered的子类
                  * 一个类型是某一个类的子类，写法就要发生对应的变化
                  * java的写法：<T/? extends Comparable>
                  * scala的写法：[T <: Comparable]
                  */
                if(first.compareTo(second) > 0) {
                    first
                } else {
                    second
                }
            }
        }

        val stu = new Student[String]("xpleaf", "jieling")
        println(stu.bigger())
        val stu2 = new Student[String]("李四", "王五")
        println(stu2.bigger())
        /**
          * Error:(43, 13) type arguments [Int] do not conform to class Student's type parameter bounds [T <: Comparable[T]]
        val stu3 = new Student[Int](18, 19)
          说明Int不是Comparable的子类

          前面Int类型可以用，实际上是scala内部，将Int（隐士）转换为RichInt
          要想让该程序运行通过，就需要使用视图界定的方式
          [T <% Comparable[T]]
          使用这个%，其实就是强制指定将Int类型隐士转换为RichInt，而RichInt间接实现了Comparable
          */
        val stu3 = new Student[Int](18, 19)
        println(stu3.bigger())

    }

    /**
      * 泛型函数或者泛型方法
      */
    def genericOps2: Unit = {
        def getStudentInfo[T](stu: Array[T]) = stu(stu.length / 2)

        val student = getStudentInfo(Array("garry", "tom", "john", "ucy", "Richard"))
        println(student)
    }

    /**
      * 泛型类的定义
      */
    def genericOps1: Unit = {
        class Student[T, S](val first: T, val second: S) {
            println(first + "\t" + second)
        }

        new Student(23, "xpleaf") // 可以做类型的自动推断
        new Student[Int, String](22, "jieling")
        new Student[Any, Any]("hadoop", "spark")
    }
}
