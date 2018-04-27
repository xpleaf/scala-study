package cn.xpleaf.bigdata.p5

import java.io.File

import scala.io.Source

object ImplicitUtil {

    implicit def double2Int(d: Double): Int = d.toInt

    implicit def str2Int(str: String): Int = str.length

    implicit def file2RichFile(file: File) = new RichFile(file)

    implicit val swr:StudentWriteReport = new StudentWriteReport()
}

class RichFile(file: File) {
    def read() = Source.fromFile(file).getLines().mkString
}

class StudentWriteReport {
    def writeReport(content:String) = println(content)
}