package cn.xpleaf.bigdata.p5.myactor

import scala.actors.Actor

/**
  * actor之线程间，互相通信
  *
  * studentActor
  *     向老师问了一个问题
  *
  * teacherActor
  *     向学生做回应
  *
  * 通信的协议：
  * 请求，使用Request(内容)来表示
  * 响应，使用Response(内容)来表示
  */
object _03CommunicationActorOps {
    def main(args: Array[String]): Unit = {
        val teacherActor = new TeacherActor()
        teacherActor.start()
        val studentActor = new StudentActor(teacherActor)
        studentActor.start()

        studentActor ! Request("老李啊，scala学习为什么这么难啊")
    }
}

case class Request(req:String)
case class Response(resp:String)

class StudentActor(teacherActor: TeacherActor) extends Actor {
    override def act(): Unit = {
        while(true) {
            receive {
                case Request(req) => {
                    // 向老师请求相关的问题
                    println("学生向老师说：" + req)
                    teacherActor ! Request(req)
                }
                case Response(resp) => {
                    println(resp)
                    println("高！")
                }
            }
        }
    }
}

class TeacherActor() extends Actor {
    override def act(): Unit = {
        while (true) {
            receive {
                case Request(req) => {  // 接收到学生的请求
                    sender ! Response("这个问题，需要如此搞定~")
                }
            }
        }
    }
}
