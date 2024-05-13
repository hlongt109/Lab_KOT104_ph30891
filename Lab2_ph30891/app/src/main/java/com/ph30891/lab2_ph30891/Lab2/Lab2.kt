package com.ph30891.lab2_ph30891.Lab2

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.text.toLowerCase
import kotlin.system.exitProcess

fun main() {
    var choice: Int
    do {
        println("========= LAB 2 - PH30891 =========")
        println("=      1. Bài 1                   =")
        println("=      2. Bài 2                   =")
        println("=      3. Bài 3                   =")
        println("=      4. Bài 4                   =")
        println("=      0. Thoát                   =")
        println("===================================")

        print("Nhập bài bạn muốn chạy : ")
        choice = readLine()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> bai1()
            2 -> bai2()
            3 -> bai3()
            4 -> bai4()
            0 -> {
                println("Đã thoát chương trình")
                exitProcess(0)
            }

            else -> println("Lựa chọn không hợp lệ, vui lòng chọn lại !")
        }
    } while (choice != 0)


}

fun bai1() {
    println("-----  giải phương trình bậc 1: ax+b=0  -----")
    var a = 0.0
    var b = 0.0
    print("Nhap a : ")
    var s = readLine()
    if (s != null) a = s.toDouble();

    print("Nhap b : ")
    s = readLine()
    if (s != null) b = s.toDouble();

    if (a == 0.0 && b == 0.0) {
        println("Phương trình vô số nghiệm")
    } else if (a == 0.0 && b != 0.0) {
        println("Phương trình vô nghiệm")
    } else {
        val kq = -b / a
        println("${a}x + $b = $kq")
    }

}

fun bai2() {
    println("-----  Tìm quý cho tháng  -----")
    var month = 0
    print("Nhap thang : ")
    val s: String? = readLine()
    if (s != null) month = s.toInt()
    when (month) {
        1, 2, 3 -> println("Tháng " + month + " thuộc quý 1")
        4, 5, 6 -> println("Tháng " + month + " thuộc quý 2")
        7, 8, 9 -> println("Tháng " + month + " thuộc quý 3")
        10, 11, 12 -> println("Tháng " + month + " thuộc quý 4")
        else -> println("Tháng " + month + " không hợp lệ")
    }
}

fun bai3() {
    println("-----  Kiem tra nam nhuan  -----")
    var year = 0
    var s: String?
    do {
        print("Nhap nam ban muon kiem tra : ")
        s = readLine()
        while (s == null || s.toInt() < 0) {
            print("Nhap sai nam, nhap lai : ")
            s = readLine()
        }
        year = s.toInt()
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            println("Năm $year là năm nhuần")
        } else {
            println("Năm $year không phải là năm nhuần")
        }

        print("Tiếp không (c / k) : ")
        s = readLine()
        if (s?.toLowerCase() == "k") break

    } while (true)
}

fun bai4() {
    var qlsv = QLSV()
    do {
        println("========= Quản lý sinh viên =========")
        println("==    1. Nhập sinh viên             =")
        println("==    2. Xem danh sách sinh vien    =")
        println("==    3. Sửa sv theo mssv           =")
        println("==    4. Xóa sv theo mssv           =")
        println("==    0. Thoát                      =")
        println("=====================================")

        print("Nhập chức năng : ")
        var choice = readLine()?.toInt() ?: -1

        when (choice) {
            1 -> qlsv.nhapThongTin()
            2 -> qlsv.xuatThongTin()
            3 -> qlsv.suaThongTin()
            4 -> qlsv.xoaSinhVienTheoMa()
            0 -> {
                println("Đã đóng bài 4")
                return
            }
            else -> println("Lựa chọn không hợp lệ, vui lòng chọn lại !")
        }

    } while (true)
}

fun demoQLSV(){

    val sv1 : SinhVienModel = SinhVienModel("Tran Hoang Long", "PH30891",9.5f)
    sv1.apply {
        tenSv = "Hoang Long"
        diemTb = 9.8f
    }
//    val sv2 : SinhVienModel = SinhVienModel("Nguyen Thien Thien", "PH31209",9.2f)
//    sv2.datotnghiep = false
//    sv2.tuoi = 20
//    val sv3 = SinhVienModel("Ng Duy Phong", "PH12345", 9.0f, false,20)
//
////    println(sv1.getThongTin())
////    println(sv2.getThongTin())
////    println(sv3.getThongTin())
//
//    // tao va su ly danh sach sinh vien
//    val listSV = mutableListOf<SinhVienModel>()
//    // add phan tu
//    listSV.add(sv1)
//    listSV.add(sv2)
//    listSV.add(sv3)
//
//    // xoa phan tu
//    listSV.removeAt(listSV.size -1) // xoa phan tu cuoi cung
//    // sua phan tu
//    val suaSv = listSV.get(0)
//    suaSv.tenSv = "Tran Thu Hien"
//    suaSv.diemTb = 10.0f
//    suaSv.datotnghiep = true
//    suaSv.tuoi = 20
//
//    // cach 1 : duyet nhanh
//    println("Duyet nhanh")
//    println("-------------------------")
//    for(sv in listSV){
//        println(sv.getThongTin())
//    }
//
//    // cach 2 : duyet co index
//    println("Duyet co index")
//    println("-------------------------")
//    for(i in listSV.indices){
//        println("Phan tu thu $i la : ${listSV.get(i).getThongTin()}")
//    }
}
class Lab2 {
}