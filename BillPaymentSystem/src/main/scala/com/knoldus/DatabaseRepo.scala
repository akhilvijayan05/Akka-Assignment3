package com.knoldus

import akka.actor.{Actor, Props}

/**
  * Created by knoldus on 23/3/17.
  */
class DatabaseRepo extends Actor{

  val salaryDepositActor = context.actorOf(Props[SalaryDepositActor])

  override def receive = {

    case user:String=>{
//println(user)
      DBInMemory.storing(user)
      DBInMemory.database foreach {case (key, value) => println (key + "-->" + value)}
      salaryDepositActor ! user
    }
    case (user:UserDetails,bill:BillerDetails)=>{

      DBInMemory.paying(user,bill)
    }
  }
}
