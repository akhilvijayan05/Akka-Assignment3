package com.knoldus

/**
  * Created by knoldus on 23/3/17.
  */
object DBInMemory {

  val database= collection.mutable.Map[String, UserDetails]()

  def storing(user:String)={

    def iterate(salaryList:List[UserDetails]):UserDetails= {

      salaryList match {

        case head :: tail  => {
          if (head.username equals user) {
            head
          }
          else
            iterate(tail)
        }

        case head :: Nil => {
          if (head.username equals user) {
            head
          }
          else
           null
        }
        case Nil=>{
          println("No data found")
          null
        }
      }
    }
   // println(user+" >>>>>>>>> "+SalaryDepositService.userAccount.toList)
    val check=iterate(SalaryDepositService.userAccount.toList)
   // println(check)
    if(check!=null)
      database += (check.username -> check)


    //println(check.username)
  }
  def paying(user:UserDetails,bill:BillerDetails)=synchronized{

//    database foreach {case (key, value) => println (key + "-->" + value)}
//    println()
    if(bill.amount<user.amount) {

      val newUserAccount=user.copy(amount = user.amount-bill.amount )
      database -=user.username
      database +=(newUserAccount.username->newUserAccount)

//      database(user.username) = UserDetails(user.holderName, user.address, user.username, user.amount - bill.amount, user.accNumber)
      //println(user.username+">>>>>>>>"+database.get(user.username))
    }
      else
      println("Insufficient balance !!")
    //    database foreach {case (key, value) => println (key + "-->" + value)}
  }
}//Thread.sleep(1000)
//object DBInMemory extends DBInMemory
