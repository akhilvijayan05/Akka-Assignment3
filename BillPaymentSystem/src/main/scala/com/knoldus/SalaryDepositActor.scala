package com.knoldus

import akka.actor.{Actor, Props}
import akka.util.Timeout
import scala.concurrent.duration.DurationInt
import akka.pattern.ask

/**
  * Created by knoldus on 23/3/17.
  */
class SalaryDepositActor extends Actor{

  //val salaryDepositService=new SalaryDepositService
  val database = context.actorOf(Props[DatabaseRepo])
  val phone = context.actorOf(Props[PhoneBillActor])
  val electricity = context.actorOf(Props[ElectricityBillActor])
  val internet = context.actorOf(Props[InternetBillActor])
  override def receive = {

    case (accNumber:Long,username:String,amount:Long)=>{

    val user=SalaryDepositService.depositing(accNumber,username,amount)
//println(SalaryDepositService.userAccount.toList)
      if(user!=Nil)
      database ! user

    }
    case user:UserDetails=>{

      phone ! user
      electricity ! user
      internet ! user

    }
    //case _=>println("no")
  }
}
