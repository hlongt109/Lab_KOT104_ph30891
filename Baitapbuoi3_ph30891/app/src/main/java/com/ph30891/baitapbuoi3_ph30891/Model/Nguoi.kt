package com.ph30891.baitapbuoi3_ph30891.Model

open class Nguoi(
    var hoTen: String,
    var tuoi: Int?,
    var queQuan: String?,
) {
   open fun nhapTtin(){
       print("Ho Ten : ")
       hoTen = readLine()?: ""
       print("Tuoi : ")
       tuoi = readLine()?.toInt() ?: 0
       print("Que quan :")
       queQuan = readLine()?:""
   }

    open fun getThongTin ():String{
        return  "$hoTen - Tuoi : $tuoi - Que: $queQuan"
    }
}