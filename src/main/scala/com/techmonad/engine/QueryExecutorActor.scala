package com.techmonad.engine

import akka.actor.{Actor, ActorRef}
import com.techmonad.es.EsHelper

class QueryExecutorActor(esHelper: EsHelper, producerActor: ActorRef) extends Actor {
  override def receive: Receive = {
    case queryDetail =>
    // parse and start query
    // publish query status into kafka query

  }
}
