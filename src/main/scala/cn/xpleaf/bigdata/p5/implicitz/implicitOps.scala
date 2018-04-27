package cn.xpleaf.bigdata.p5.implicitz

/**
  * scala隐士转换操作
  *     将一种类型，转化为另外的一种类型，这完成这一操作的背后就是隐士转换函数
  *     所谓隐士转换函数，其实就是在普通函数前面加上一个关键字——implicit
  *
  *     隐士转换函数的导入：
  *         1、如果隐士转换函数和调用它的操作，在同一个文件中，我们不要做任何操作
  *         2、如果不在一个文件中，需要收到导入，和导包是一样，唯一需要注意最后以._结尾，表导入该类中的所有的隐士转换函数
  *
  */
import java.io.File

import cn.xpleaf.bigdata.p5.ImplicitUtil._
import cn.xpleaf.bigdata.p5.StudentWriteReport

import scala.io.Source
object implicitOps {
    def main(args: Array[String]): Unit = {
//        implicitOps1
//        implicitOps2
        implicitOps3
    }

    /**
      * 隐士转换参数
      * 其实就非常类似于之前学习过的柯里化
      */
    def implicitOps3: Unit = {
        /*  // 传统操作方式
        def signReport(name:String, swr:StudentWriteReport): Unit = {
            swr.writeReport(name)
        }

        signReport("张三", new StudentWriteReport())*/


        def signForReport(name:String)(implicit swr:StudentWriteReport): Unit = {
            swr.writeReport(name)
        }

        signForReport("张三")
    }

    /*
    class StudentWriteReport {
        def writeReport(content:String) = println(content)
    }

    implicit val swr:StudentWriteReport = new StudentWriteReport()
    */

    /**
      * 使用隐士转换丰富现在类型的API
      */
    def implicitOps2: Unit ={

        var file = new File("/Users/yeyonghao/test.txt")

        var lines = file.read()

        println(lines)
    }

    /**
      * 隐士转换操作
      */
    def implicitOps1: Unit = {
        val x:Int = 3
        val y:Int = 3.5
        val z:Int = "klkelfldlkfj"

        println("x=" + x)
        println("y=" + y)
        println("z=" + z)

    }

}


