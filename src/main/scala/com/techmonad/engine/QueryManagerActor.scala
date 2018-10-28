package com.techmonad.engine

import akka.actor.Actor

class QueryManagerActor extends Actor {
  override def receive: Receive = {
    case _ =>
      // receive query and start child actor submit query
  }
}
