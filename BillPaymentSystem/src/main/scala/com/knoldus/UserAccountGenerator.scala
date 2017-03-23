package com.knoldus

import akka.actor.Actor

/**
  * Created by knoldus on 23/3/17.
  */
class UserAccountGenerator extends Actor{

//val userService=new UserAccountService

  override def receive = {

    case (user:UserDetails,num:Int)=>{
      UserAccountService.verifying(user,num)
      sender() ! true
    }
  }
}
