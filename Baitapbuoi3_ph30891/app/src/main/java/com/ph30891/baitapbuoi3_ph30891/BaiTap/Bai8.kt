package com.ph30891.baitapbuoi3_ph30891.BaiTap

import kotlin.system.exitProcess

fun main() {
    val qltm = QLTM()
    var choice:Int
    do {
        println("============== Bai 8 ==============")
        println("=  1. Them the muon               =")
        println("=  2. Xem danh the muong          =")
        println("=  3. Sua the muon                =")
        println("=  4. Xoa the muon                =")
        println("=  0. Thoát                       =")
        println("===================================")

        print("Nhập chức năng : ")
        choice = readLine()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> qltm.nhapTheMuon()
            2 -> qltm.xuatDanhSachThe()
            3 -> qltm.suaTheMuon()
            4 -> qltm.xoaTheMuon()
            0 ->{
                println("Đã thoát chương trình")
                exitProcess(0)
            }
            else -> println("Lựa chọn không hợp lệ, vui lòng chọn lại !")
        }

    }while (choice != 0)
}
class Bai8 {
}