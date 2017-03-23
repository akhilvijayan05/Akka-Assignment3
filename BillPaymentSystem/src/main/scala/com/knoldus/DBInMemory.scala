package com.knoldus

/**
  * Created by knoldus on 23/3/17.
  */
class DBInMemory {

  val database= collection.mutable.Map[String, UserDetails]()
  val userService=new UserAccountService

  def storing(user:String)={

    def iterate(salaryList:List[UserDetails]):Boolean= {

      salaryList match {

        case head :: tail  => {
          if (head.username equals user) {
            database += (head.username -> head)
            true
          }
          else
            iterate(tail)
        }

        case head :: Nil => {
          if (head.username equals user) {
            database += (head.username -> head)
            true
          }
          else
            false
        }
      }
    }
   // println(user+" >>>>>>>>> "+SalaryDepositService.userAccount.toList)
    iterate(SalaryDepositService.userAccount.toList)

    //println(check.username)
  }
  def paying(user:UserDetails,bill:BillerDetails)=synchronized{

//    database foreach {case (key, value) => println (key + "-->" + value)}
//    println()
    database(user.username)=UserDetails(user.holderName,user.address,user.username,user.amount-bill.amount,user.accNumber)
//    database foreach {case (key, value) => println (key + "-->" + value)}
  }
}
object DBInMemory extends DBInMemory
