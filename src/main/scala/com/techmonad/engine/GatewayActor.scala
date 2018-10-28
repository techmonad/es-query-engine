package com.techmonad.engine

import akka.actor.{Actor, ActorRef}

class GatewayActor(queryManagerActor: ActorRef) extends Actor {
  override def receive: Receive = {
    case queryId: String =>
    //get query details
    //create or update query status
    //send to QueryManager

  }
}

