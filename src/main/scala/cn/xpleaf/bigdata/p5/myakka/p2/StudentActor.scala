package cn.xpleaf.bigdata.p5.myakka.p2

import akka.actor.{Actor, ActorLogging, ActorRef}
import cn.xpleaf.bigdata.p5.myakka.MessageProtocol.{InitSign, QuoteRequest, QuoteResponse}

/**
  * Student Actor
  * 当学生接收到InitSign信号之后，便向老师发送一条Request请求的消息
  */
class StudentActor(teacherActorRef:ActorRef) extends Actor with ActorLogging {
    override def receive = {
        case InitSign => {
            teacherActorRef ! QuoteRequest()
//            println("student send request")
        }
        case QuoteResponse(resp) => {
            log.info(s"$resp")
        }
    }
}
