package com.knoldus

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import scala.concurrent.duration._
import akka.pattern.ask
import scala.concurrent.Await

/**
  * Created by knoldus on 23/3/17.
  */
object Main extends App{

  val system = ActorSystem("Book")
  val props = Props[UserAccountGenerator]
  val router = system.actorOf(props)
  val props1 = Props[SalaryDepositActor]
  val router1 = system.actorOf(props1)

//  for(i <- 100 to 110)
//    router ! (UserDetails("Akhil","Delhi","akhil"),i)



  for(i <- 100 to 110) {
    implicit val timeout = Timeout(1000 seconds)
    val f=router ? (UserDetails("Akhil", "Delhi", "akhil"), i)
    Await.result(f,timeout.duration)
  }
//  println(UserAccountService.userDetails.toList)
for(i <- 100 to 110) {
//println("akhil"+i+1)
  router1 ! (i.toLong, "akhil" + i + 1, (10000 + i).toLong)
}
}
