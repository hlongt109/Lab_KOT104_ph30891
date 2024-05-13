package com.ph30891.baitapbuoi3_ph30891.BaiTap

import kotlin.system.exitProcess

fun main() {
    val qlgv = QLGV()
     var choice: Int
     do {
         println("============== Bai 7 ==============")
         println("=  1. Them giao vien              =")
         println("=  2. Xem danh sach giao vien     =")
         println("=  3. Sua giao vien               =")
         println("=  4. Xoa giao vien               =")
         println("=  0. Thoát                       =")
         println("===================================")

         print("Chon chuc nang : ")
         choice = readLine()?.toIntOrNull()?: -1

         when (choice) {
             1 -> qlgv.nhapThongTin()
             2 -> qlgv.xuatThongTin()
             3 -> qlgv.suaThongTin()
             4 -> qlgv.xoaGiaoVien()
             0 -> {
                 println("Đã thoát chương trình")
                 exitProcess(0)
             }
             else -> println("Lựa chọn không hợp lệ, vui lòng chọn lại !")
         }
     }while (choice != 0)
}
class BaiTap {

}