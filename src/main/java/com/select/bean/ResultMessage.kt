package com.combofish.selectsubject.bean

data class ResultMessage(var flag:Int = 0,var msg:String = ""){
    fun setData(f:Int,s:String){
        flag = f
        msg = s
    }
}