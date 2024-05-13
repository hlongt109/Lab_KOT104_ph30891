package com.ph30891.baitapbuoi3_ph30891.Model

class CBGV(
    var luongCung: Float,
    var luongThuong: Float,
    var tienPhat: Float,
    var luongThucLinh: Float,
    hoTen: String,
    tuoi: Int,
    queQuan: String,
    maSo: String
) : Nguoi(hoTen, tuoi, queQuan, maSo) {

    constructor():this(0.0f, 0.0f, 0.0f, 0.0f,"",0,"","")

    fun tinhLuongThucLinh() : Float{
        return  luongCung + luongThuong - tienPhat
    }

    fun nhapTT(){
        println("Nhap thong tin giao vien ")
        print("Ho Ten : ")
        hoTen = readLine()?: ""
        print("Tuoi : ")
        tuoi = readLine()?.toInt() ?: 0
        print("Que quan :")
        queQuan = readLine()?:""
        print("Ma so GV :")
        maSo = readLine()?:""
        print("Luong cứng :")
        luongCung = readLine()?.toFloat() ?: 0.0f
        print("Lương thưởng :")
        luongThuong = readLine()?.toFloat() ?: 0.0f
        print("Tiền phạt : ")
        tienPhat = readLine()?.toFloat() ?: 0.0f
        luongThucLinh = tinhLuongThucLinh()
    }

    fun getTT(): String{
        var thongtin: String = "MSGV: ${maSo}, Ho ten: $hoTen, Tuoi: $tuoi, Que quan: $queQuan, Luong cung: $luongCung, Luong thuong: $luongThuong, Luong Thuc Linh: $luongThucLinh"
        return  thongtin
    }
}