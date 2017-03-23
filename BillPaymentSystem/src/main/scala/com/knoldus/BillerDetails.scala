package com.knoldus

/**
  * Created by knoldus on 23/3/17.
  */

sealed trait Category

case object phone extends Category

case object electricity extends Category

case object internet extends Category

case object food extends Category

case object car extends Category

case class BillerDetails(billerCategory:Category,billerName:String,accNumber:Long,transDate:String,amount:Long,totalIter:Int,executedIter:Int,paid_Amount:Long)

