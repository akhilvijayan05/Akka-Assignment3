package com.knoldus

import akka.actor.{Actor, Props}

/**
  * Created by knoldus on 23/3/17.
  */
class DatabaseRepo extends Actor{

  val salaryDepositActor = context.actorOf(Props[SalaryDepositActor])

  override def receive = {

    case user:String=>{
     // Thread.sleep(2000)
//println(user)
      DBInMemory.storing(user)
     // println(DBInMemory.database)
      //DBInMemory.database foreach {case (key, value) => println (key + "-->" + value)}
      salaryDepositActor ! DBInMemory.database(user)
    }
    case (user:UserDetails,bill:BillerDetails)=>{

      DBInMemory.paying(user,bill)
//      sender() ! "Done"
    }
  }
}
