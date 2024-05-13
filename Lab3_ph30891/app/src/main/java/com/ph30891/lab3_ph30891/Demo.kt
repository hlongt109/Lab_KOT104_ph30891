package com.ph30891.lab3_ph30891

fun main() {
    val soA = 5
    var soB = 10

    val luyThuaBac3 = soA.let{
        val kq = it * it * it
        kq
    }
    val title = "Buoi 3 - Android Kotlin"
//    val length = title.let {
//        if(it == null){
//            0
//        }else{
//            it.length
//        }
//    }
    val length = title?.run {
        if(isEmpty()){
            0
        }else{
            length
        }
    }

    with(soB){
        soB = this.inc()
        println("So B duoc tang = $soB ")
    }
    println("Do dai chuoi $title co $length ky tu")

    println("Tong : $soA + $soB = ${tinhTong(soA, soB)}")
    println("Tich : $soA * $soB = ${phepNhan(soA, soB)}")
    println("Thuong : $soA / $soB = ${phepChia(soA.toFloat(), soB.toFloat())()}")
    println("Luy Thua cua so $soA = ${luyThua(soA)}")
    println("Luy Thua bac 3 cua so $soA = ${luyThuaBac3}")
}

val tinhTong = { soA: Int, soB: Int -> (soA + soB) }
val phepNhan: (Int, Int) -> Int = { soA: Int, soB: Int -> (soA * soB) }

val phepChia = { soA: Float, soB: Float -> {
      if(soB == 0f){
          "so bi chia phai khac 0"
      }else{
          val kq = soA / soB
          kq
      }
    }
}


val luyThua : (Int) -> Int = {it * it}

class Demo {
}