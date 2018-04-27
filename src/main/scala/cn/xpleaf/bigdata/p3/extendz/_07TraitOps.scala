package cn.xpleaf.bigdata.p3.extendz

/**
  * scala特质说明
  *     scala中同样像java一样不能实现多继承，只能通过多实现来弥补，同时多实现，要比多继承灵活的多
  * 在java中的实现，我们称之为接口interface，使用关键字implement
  * 在scala中，我们称之为特质trait，使用关键字extends
  * 如果在java中实现的是多个接口，接口之间使用","隔开
  * 如果在scala中继承的是多个特质，特质之间使用with隔开
  *
  *     trait是一个比较特殊的结构
  *         既可以有抽象方法，也可以有非抽象方法，如果trait中的方法都是抽象的，我们就可以将其看作java的接口
  *     当我们扩展的多个特质，拥有相同的方法的时候，默认只会调用最右面一个特质的方法
  *
  *     要求：
  *       如果继承的多个特质含有相同方法，我们想执行每一个方法，怎么解决？
  *         则在继承的特质后面追加一个super.方法即可
  *         注意，当前根特质中的方法必须不能为抽象
  *       当扩展的特质是多个的话，执行顺序是从右往左
  */
object _07TraitOps {
  def main(args: Array[String]): Unit = {
    val cLog:Log = new ConsoleLog
    cLog.log("日志信息")
    println("==================")
    val mLog:MainLog = new MainLog
    mLog.log("info")
  }
}

/**
  * 定义了一个特质log，有一个抽象的方法log
  */
trait Log {

  def log(msg:String): Unit = {

  }

}

class ConsoleLog extends Log {
  override def log(msg: String): Unit = {
    println(s"将 ${msg} 输出到Console")
  }
}

trait FileLog extends Log {
  override def log(msg: String): Unit = {
    println(s"将 ${msg} 输出到File")
    super.log(msg)
  }
}

trait FlumeLog extends Log {
  override def log(msg: String): Unit = {
    println(s"将 ${msg} 采集到Flume")
    super.log(msg)
  }
}

class MainLog extends FileLog with FlumeLog {
  override def log(msg: String): Unit = {
    super.log(msg)
  }
}


