package com.ph30891.baitapbuoi3_ph30891.BaiTap

import androidx.compose.ui.text.toLowerCase
import com.ph30891.baitapbuoi3_ph30891.Model.CBGV

class QLGV {
    val ListGV = mutableListOf<CBGV>()
    fun nhapThongTin(){
        do {
            val gv = CBGV()
            gv.nhapTT()
            ListGV.add(gv)

            print("Có nhập tiếp không ? (c / k) : ")
            var s = readLine()
            if(s?.toLowerCase() == "k") break
        }while (true)
    }
    fun xuatThongTin(){
        println("=========== Danh sach giao vien ============")
        for(gv in ListGV){
            println(gv.getTT())
        }
    }
    fun suaThongTin(){
        println("=========== Sua thong tin giao vien ============")
        print("Nhap ma so gv : ")
        val msgv = readLine().toString().toLowerCase()
        for (gv in ListGV){
            if(gv.maSo.toLowerCase() == msgv){
                gv.nhapTT()
                println(gv.getTT())
                break
            }
        }
    }
    fun xoaGiaoVien(){
        print("Nhap ma so gv : ")
        val msgv = readLine().toString().toLowerCase()
        for(gv in ListGV){
            if(gv.maSo.toLowerCase() == msgv) {
                ListGV.remove(gv)
                xuatThongTin()
                return
            }
        }
    }
}