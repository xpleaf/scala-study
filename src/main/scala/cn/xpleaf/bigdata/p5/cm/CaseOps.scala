package cn.xpleaf.bigdata.p5.cm

/**
  * scala中的模式匹配
  *     错误: 找不到或无法加载主类 cn.xpleaf.bigdata.p5.`case`.CaseOps
  *
  *     这里的问题出在将关键字作为类名中的一部分
  *     所以今后的书写过程中尽量不要将关键字作为类名或者包名
  */
object CaseOps {
  def main(args: Array[String]): Unit = {
//    caseOps1
//    caseOps2
//    caseOps3
//    caseOps4
//    caseOps5
//    caseOps6
//    caseOps7
    caseOps8
  }

  def caseOps8: Unit = {
    def optionOps: Unit = {
      val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo", "BeiJing" -> "通州")

      println(capitals.get("Japan") + show(capitals.get("Japan")))
      println(capitals.get("BeiJing") + show(capitals.get("India")))
    }

    def show(x: Option[String]) = x match {
      case Some(s) => s
      case None => "?"
    }

    optionOps

  }

  /**
    * 样例类（case class）的模式匹配
    */
  def caseOps7: Unit = {
    abstract class Expr
    case class Var(name:String) extends Expr
    case class UnOp(operator:String, arg:Expr) extends Expr
    case class BinOp(operator:String, left:Expr, right:Expr) extends Expr

    def test(expr:Expr) = expr match {
      case Var(name) => println(s"Var($name)...")
      case UnOp(operator, e) => println(s"$e ... $operator")
      case BinOp(operator, left, right) => println(s"$left $operator $right")
      case _ => println("default")
    }

    test(BinOp("+", Var("1"), Var("2")))

  }

  /**
    * 匹配scala数组
    */
  def caseOps6: Unit = {
    val arr = Array(0, 1)
    arr match {
      //匹配只有一个元素的数组，且元素就是0
      case Array(0) => println("0")
      // 匹配任何带有两个元素的数组，并将元素绑定到x和y
      case Array(x, y) => println(x + " " + y)
      // 匹配任何以0开始的数组
      case Array(0, _*) => println("0 ...")
      case _ => println("something else")
    }
  }

  /**
    * 使用模式匹配可以代替isInstanceOf和asInstanceOf来进行使用
    */
  def caseOps5: Unit = {
    def typeOps(x: Any): Int = {
      val result = x match {
        case i: Int => i
        case s: String => Integer.parseInt(s)
        case z: scala.math.BigInt => Int.MaxValue
        case c: Char => c.toInt
        case _ => 0
      }
      result
    }

    println(typeOps("12345") == 12345)

  }

  /**
    * 将要进行匹配的值，赋值给case后面的变量，我们可以对变量进行各种操作
    */
  def caseOps4: Unit = {
    "Hello, wordl" foreach(c => println(
      c match {
        case ' ' => "space"
        case ch => "Char: " + ch
      }
    ))
  }

  /**
    * match模式匹配当做守卫进行使用
    */
  def caseOps3: Unit = {
    val ch:Char = 'a'
    var sign = -1
    ch match {
      case '+' => sign = 1
      case '-' => sign = -1
      case _ if Character.isDigit(ch) => sign = 2
      case _ if Character.isAlphabetic(ch) => sign = 3
      case _ => sign = -2
    }
    println("sign = " + sign)
  }

  /**
    * scala中的任何表达式都是有返回值的，模式匹配也不例外，我们可以直接获取对应的返回值进行操作
    * 如果不写case _的操作，匹配不上的话，会抛出相关异常：scala.MatchError
    */
  def caseOps2: Unit = {
    val ch = '1'
    val sign = ch match {
      case '+' => 1
      case '-' => 0
      case _ => 2
    }
    println(sign)
  }

  /**
    * 一般情况下也就是将模式匹配当做java中的switch case来进行使用
    */
  def caseOps1: Unit = {
    val ch = '1'
    var sign = -1
    ch match {
      case '+' => sign = 1
      case '-' => sign = 0
      case _ => sign = 2
    }
    println(sign)
  }
}
