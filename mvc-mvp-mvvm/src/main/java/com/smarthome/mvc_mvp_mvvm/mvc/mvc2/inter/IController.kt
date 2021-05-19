package com.smarthome.mvc_mvp_mvvm.mvc.mvc2.inter

// 控制器接口，定义控制器的逻辑
interface IController {
    // EditText 数据变化，通知控制器
    fun onDataChanged(data: String)
    // 清空按钮点击事件
    fun clearData()
}