package com.smarthome.mvc_mvp_mvvm.mvc.mvc2.inter

import com.smarthome.mvc_mvp_mvvm.mvc.mvc2.inter.IController

// 视图接口，定义视图的操作
interface IView {
    fun setController(controller: IController)
    // 数据处理中状态
    fun dataHanding()
    // 数据处理完成，更新界面
    fun onDataHandled(data: String)
}