package com.knoldus

import akka.actor.{Actor, Props}

/**
  * Created by knoldus on 23/3/17.
  */
class ElectricityBillActor extends Actor{

  val database = context.actorOf(Props[DatabaseRepo])
  override def receive = {

    case user:UserDetails=> database ! (user,BillerDetails(electricity,"Yamuna Power",user.accNumber,"23/3/2017",1000,3,0,0))

  }
}
