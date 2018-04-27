package cn.xpleaf.bigdata.p5.myakka.p2

import akka.actor.{ActorSystem, Props}
import cn.xpleaf.bigdata.p5.myakka.MessageProtocol.InitSign

object DriverApp {
    def main(args: Array[String]): Unit = {
        val actorSystem = ActorSystem("teacherStudentSystem")
        // 老师的代理对象
        val teacherActorRef = actorSystem.actorOf(Props[TeacherActor], "teacherActor")
        // 学生的代理对象
        val studentActorRef = actorSystem.actorOf(Props[StudentActor](new StudentActor(teacherActorRef)), "studentActor")

        studentActorRef ! InitSign

        Thread.sleep(2000)

        actorSystem.shutdown()
    }
}
