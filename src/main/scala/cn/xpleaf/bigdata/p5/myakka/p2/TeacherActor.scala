package cn.xpleaf.bigdata.p5.myakka.p2

import akka.actor.Actor
import cn.xpleaf.bigdata.p5.myakka.MessageProtocol.{QuoteRequest, QuoteResponse}

import scala.util.Random

/**
  * Teacher Actor
  */
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
//            println(response)
            sender ! response
        }
    }
}
