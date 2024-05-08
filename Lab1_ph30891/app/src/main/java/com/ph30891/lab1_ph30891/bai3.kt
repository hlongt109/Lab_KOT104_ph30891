package com.ph30891.lab1_ph30891

fun main() {
    var a = 0.0
    var b = 0.0
    print("Nhap a : ")
    var s = readLine()
    if(s != null) a = s.toDouble()
    print("Nhap b : ")
    s = readLine()
    if(s != null) b = s.toDouble()

    println("Tong : "+ (a + b))
    println("Hieu : "+ (a - b))
    println("Tich : "+ (a * b))
    println("Thuong : "+ (a / b))
}
