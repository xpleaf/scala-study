package cn.xpleaf.bigdata.p5.myakka.p1

import akka.actor.{Actor, ActorSystem, Props}
import cn.xpleaf.bigdata.p5.myakka.MessageProtocol.{QuoteRequest, QuoteResponse}

import scala.util.Random

/**
  * 基于AKKA Actor的单向通信案例
  * 学生向老师发送请求
  */
object _01StudentActorOps {
    def main(args: Array[String]): Unit = {
        // 第一步：构建Actor操作系统
        val actorSystem = ActorSystem("StudentActorSystem")
        // 第二步：actorSystem创建TeacherActor的代理对象ActorRef
        val teacherActorRef = actorSystem.actorOf(Props[TeacherActor])
        // 第三步：发送消息
        teacherActorRef ! QuoteRequest()

        Thread.sleep(2000)
        // 第四步：关闭
        actorSystem.shutdown()
    }
}

class TeacherActor extends Actor {
    val quotes = List(
        "Moderation is for cowards",
        "Anything worth doing is worth overdoing",
        "The trouble is you think you have time",
        "You never gonna know if you never even try")

    override def receive = {
        case QuoteRequest() => {
            val random = new Random()

            val randomIndex = random.nextInt(quotes.size)
            val randomQuote = quotes(randomIndex)

            val response = QuoteResponse(randomQuote)
            println(response)
        }
    }
}
