package com.techmonad.kafka.consumer

import akka.actor.{Actor, ActorRef}

import scala.concurrent.duration._

class ConsumerActor(consumer: Consumer, gatewayActor: ActorRef) extends Actor {

  import ConsumerActor._
  import context.dispatcher

  context.system.scheduler.scheduleOnce(100 millis, self, Read)

  override def receive: Receive = {
    case Read =>
      val messages = consumer.read()
      if (messages.nonEmpty) {
        messages foreach (message => gatewayActor ! message)
        self ! Read
      } else {
        context.system.scheduler.scheduleOnce(1 seconds, self, Read)
      }
  }

}

object ConsumerActor {

  case object Read

}

