package com.ph30891.baitapbuoi3_ph30891.Model

class CBGV(
    var luongCung: Float,
    var luongThuong: Float?,
    var tienPhat: Float?,
    var luongThucLinh: Float,
    var maSo: String,
    hoTen: String,
    tuoi: Int,
    queQuan: String,
) : Nguoi(hoTen, tuoi, queQuan) {

    constructor():this(0.0f, 0.0f, 0.0f, 0.0f,"","",0,"")

    fun tinhLuongThucLinh() : Float{
        return  luongCung + (luongThuong?:0f) - (tienPhat?:0f)
    }

    fun nhapTT(){
        println("Nhap thong tin giao vien ")
        super.nhapTtin()
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
        var thongtin = "${super.getThongTin()} - msgv : $maSo - Luong cung: $luongCung - Luong thuong : $luongThuong - Tien phat : $tienPhat- Luong Thuc Linh: $luongThucLinh"
        return  thongtin
    }
}