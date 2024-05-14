package com.ph30891.baitapbuoi3_ph30891.Demo

open class NguoiModel(
    var hoten: String,
    var tuoi: Int?,
    var quequan: String?,
) {
   open fun getThongTin ():String{
        return  "$hoten - Tuoi : $tuoi - Que: $quequan"
    }
}