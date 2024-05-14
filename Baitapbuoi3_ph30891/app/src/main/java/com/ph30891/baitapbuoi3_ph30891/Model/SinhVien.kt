package com.ph30891.baitapbuoi3_ph30891.Model

open class SinhVien(
    var hoTen: String,
    var tuoi: Int?,
    var lop: String
) {
    constructor():this ("",0,"")

    open fun nhapTTSV(){
        println("=========== Nhap thong tin sinh vien ============")
        print("Tên sinh viên : ")
        hoTen = readLine() ?: ""
        print("Tuổi sinh viên : ")
        tuoi = readLine()?.toInt() ?: 0
        print("Nhập lớp của sinh viên : ")
        lop = readLine()?:""
    }

    open fun getTTSV():String{
        val tt = "Ho Ten : $hoTen, Tuổi : $tuoi, Lop : $lop"
        return tt
    }
}