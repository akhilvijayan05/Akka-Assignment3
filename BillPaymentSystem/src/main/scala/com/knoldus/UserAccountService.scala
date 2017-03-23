package com.knoldus

import scala.collection.mutable.ListBuffer

/**
  * Created by knoldus on 23/3/17.
  */
class UserAccountService{

  val userDetails=ListBuffer[UserDetails]()

  def verifying(user:UserDetails,num:Int)={

    def iterate(userList:List[UserDetails]):Boolean= {

      userList match {

        case head :: tail =>{
          if (head.username equals user.username)
            true
          else
            iterate(tail)
        }

        case head :: Nil => {

          if (head.username equals user.username)
          true
          else
            false
        }
        case Nil=>false
      }
    }
    val check=iterate(userDetails.toList)

    if(check==true)
      println("UserName already exists !!")
    else
   // println(user.username+num+1)
      userDetails.append(user.copy(accNumber = num, username = user.username + num + 1))
  }
}

object UserAccountService extends UserAccountService

