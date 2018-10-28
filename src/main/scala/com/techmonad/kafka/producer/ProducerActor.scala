package com.techmonad.kafka.producer

import akka.actor.Actor

class ProducerActor(producer: Producer) extends Actor {

  import ProducerActor._

  override def receive: Receive = {
    case Message(topic, info) =>
      producer.send(topic, info)

  }

}

object ProducerActor {

  case class Message(topic: String, info: String)

}
