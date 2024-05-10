package com.ph30891.lab2_ph30891.Lab2

class SinhVienModel(var tenSv: String, var mssv: String, var diemTb: Float) {
    var datotnghiep: Boolean? = null
    var tuoi: Int? = null

    constructor() : this("", "", 0.0f)
    constructor(tenSv: String, mssv: String, diemTb: Float, datotnghiep: Boolean, tuoi: Int) : this(
        tenSv,
        mssv,
        diemTb
    ) {
        this.datotnghiep = datotnghiep
        this.tuoi = tuoi
    }

    fun nhapThongTin() {
        println("Nhập thông tin sinh viên:")
        print("Tên sinh viên: ")
        tenSv = readLine() ?: ""

        print("Mã số sinh viên: ")
        mssv = readLine() ?: ""

        print("Điểm trung bình: ")
        diemTb = readLine()?.toFloatOrNull() ?: 0.0f

        print("Đã tốt nghiệp (0 / 1): ")
        val input = readLine()?.toIntOrNull()
        datotnghiep = when (input) {
            1 -> true
            0 -> false
            else -> null
        }

        print("Tuổi: ")
        tuoi = readLine()?.toIntOrNull()
    }

    fun getThongTin(): String {
        var thongtin: String
        if (datotnghiep != null && tuoi != null) {
            thongtin =
                "Ten: $tenSv , mssc: $mssv , diemTb: $diemTb , da tot nghiep : $datotnghiep , tuoi: $tuoi"
        } else {
            thongtin = "Ten: $tenSv , mssc: $mssv , diemTb: $diemTb"
        }

        return thongtin
    }
}