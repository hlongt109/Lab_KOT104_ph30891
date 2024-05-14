package com.ph30891.baitapbuoi3_ph30891.Model

class TheMuon(
    var maPhieuMuon: String,
    var ngayMuon: Int,
    var hanTra: Int,
    var soHieuSach: String,
    hoTen: String,
    tuoi: Int?,
    lop: String
) : SinhVien(hoTen, tuoi, lop) {
    constructor() : this("", 0, 0, "", "", 0, "")

    fun nhapTTTM() {
        println("=========== Nhap thong tin the muon ============")
        print("Nhap ma the muon :")
        maPhieuMuon = readLine() ?: ""
        print("Nhap ngay muon :")
        ngayMuon = readLine()?.toInt() ?: 0
        print("Nhap han tra :")
        hanTra = readLine()?.toInt() ?: 0
        print("Nhap so hieu sach :")
        soHieuSach = readLine() ?: ""
        super.nhapTTSV()
    }

    fun getTTTM(): String {
        return "Ma Phieu Muon: $maPhieuMuon -Ngay Muon: $ngayMuon -Han Tra: $hanTra -So Hieu Sach: $soHieuSach, -${super.getTTSV()}"
    }
}