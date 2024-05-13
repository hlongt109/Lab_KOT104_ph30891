package com.ph30891.baitapbuoi3_ph30891.BaiTap

import com.ph30891.baitapbuoi3_ph30891.Model.TheMuon

class QLTM {
    val ListTM = mutableListOf<TheMuon>()
    fun nhapTheMuon(){
        do {
            val themuon = TheMuon()
            themuon.nhapTTTM()
            ListTM.add(themuon)

            print("Tiếp không (c / k) : ")
            var s = readLine()

            if (s?.toLowerCase() == "k") break
        }while (true)
    }

    fun xuatDanhSachThe(){
        println("===== Danh sach the muon =====")
        for (tm in ListTM) {
            println(tm.getTTTM())
        }
    }
    fun suaTheMuon(){
        println("Sua thong tin the muon")
        print("Nhap ma the : ")
        val m = readLine().toString().toLowerCase()
        for(tm in ListTM){
            if(tm.maPhieuMuon.toLowerCase() == m){
                tm.nhapTTTM()
                println(tm.getTTTM())
                break
            }
        }
    }
    fun xoaTheMuon(){
        println("Xoa thong tin the muon")
        print("Nhap ma the muon  : ")
        val m = readLine().toString().toLowerCase()
        for(tm in ListTM){
            if(tm.maPhieuMuon.toLowerCase() == m){
                ListTM.remove(tm)
                xuatDanhSachThe()
                return
            }
        }
    }
}