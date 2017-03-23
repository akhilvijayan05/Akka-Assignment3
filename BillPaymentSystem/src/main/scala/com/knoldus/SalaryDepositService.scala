/**
  * Created by knoldus on 23/3/17.
  */
package com.knoldus

import scala.collection.mutable.ListBuffer


class SalaryDepositService {

  val userAccount=ListBuffer[UserDetails]()

  def depositing(accNumber:Long,username:String,salary:Long)={

    def iterate(userList:List[UserDetails]):UserDetails= {

      userList match {

        case head :: tail  => {
          if (head.accNumber equals accNumber) {
            val user = head.copy(amount = salary)
            userAccount.append(user)
            user
          }
          else
            iterate(tail)
        }

        case head :: Nil => {
          if (head.accNumber equals accNumber) {
            val user = head.copy(amount = salary)
            userAccount.append(user)
            user
          }
          else
            null
        }
      }
    }

    val check=iterate(UserAccountService.userDetails.toList)

    //println(check.username)
    if(check!=null)
      check.username
  }
}
object SalaryDepositService extends SalaryDepositService
