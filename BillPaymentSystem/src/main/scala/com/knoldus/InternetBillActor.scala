package com.knoldus

import akka.actor.{Actor, Props}

/**
  * Created by knoldus on 23/3/17.
  */
class InternetBillActor extends Actor{

  val database = context.actorOf(Props[DatabaseRepo])
  override def receive = {

    case user:UserDetails=> database ! (user,BillerDetails(internet,"Den BoomBand",user.accNumber,"23/3/2017",1000,3,0,0))
      //context.actorOf(Props[DatabaseRepo]).forward(user,BillerDetails(internet,"Den BoomBand",user.accNumber,"23/3/2017",1000,3,0,0))
  }
}
