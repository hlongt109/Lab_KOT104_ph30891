package com.ph30891.lab2_ph30891

fun main() {
    // lam viec voi null safety
    // cho phep bien la null
    val tenSv : String? = "Tran Hoang Long"

    // val mssv = getThongTinSv(tenSv!!)  // !! khang dinh bien khac null

    if(tenSv != null){
        val mssv = getThongTinSv(tenSv!!)
        println("MSSV cua $tenSv : $mssv")
    }
}
fun getThongTinSv(tenSv : String) : String?{
    when(tenSv){
        "Tran Hoang Long" -> {
            return "PH30891"
        }
        "Nguyen Thien THien" -> return "PH31209"
        else -> return null
    }
    return null
}
class Baitrenlop {
}