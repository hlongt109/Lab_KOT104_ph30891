package com.ph30891.baitapbuoi3_ph30891.Model

class TheMuon(
    var maPhieuMuon: String,
    var ngayMuon: Int,
    var hanTra: Int,
    var soHieuSach: String,
    var sinhVien: SinhVien?
):SinhVien() {
    constructor():this("",0,0,"",null)
    fun nhapTTTM(){
        println("=========== Nhap thong tin the muon ============")
        print("Nhap ma the muon :")
        maPhieuMuon = readLine()?:""
        print("Nhap ngay muon :")
        ngayMuon = readLine()?.toInt() ?: 0
        print("Nhap han tra :")
        hanTra = readLine()?.toInt() ?: 0
        print("Nhap so hieu sach :")
        soHieuSach = readLine()?:""
//        val sv = SinhVien()
//        sv.nhapTTSV()
//        sinhVien = sv
        sinhVien.run { nhapTTSV() }
    }

    fun getTTTM():String{
        val tt = "Ma Phieu Muon: $maPhieuMuon, Ngay Muon: $ngayMuon, Han Tra: $hanTra, So Hieu Sach: $soHieuSach,${getTTSV()}"
        return tt
    }
}