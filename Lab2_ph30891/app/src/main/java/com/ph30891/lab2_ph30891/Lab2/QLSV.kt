package com.ph30891.lab2_ph30891.Lab2

import androidx.compose.ui.text.toLowerCase

class QLSV {
    private val ListSV = mutableListOf<SinhVienModel>()
    fun nhapThongTin() {
        do {
            val sinhVien = SinhVienModel()
            sinhVien.nhapThongTin()
            ListSV.add(sinhVien)

            print("Tiếp không (c / k) : ")
            var s = readLine()

            if (s?.toLowerCase() == "k") break
        } while (true)
    }

    fun xuatThongTin() {
//        println(ListSV.size)
        println("===== Danh sach sinh vien =====")
        for (sv in ListSV) {
            println(sv.getThongTin())
        }
    }

    fun suaThongTin() {
        println("Sua thong tin sinh vien")
        print("Nhap mssv : ")
        val ma = readLine().toString().toLowerCase()
        for (sv in ListSV) {
            if (sv.mssv.toLowerCase() == ma) {
                sv.nhapThongTin()
                println(sv.getThongTin())
                break
            }
        }
    }

    fun xoaSinhVienTheoMa() {
        print("Nhap mssv muon xoa : ")
        val ma = readLine().toString().toLowerCase()
        for(sv in ListSV){
            if (sv.mssv.toLowerCase() == ma) {
                ListSV.remove(sv)
                xuatThongTin()
                return
            }
        }
    }
}