package com.smarthome.mvc_mvp_mvvm.mvp.inter

import com.smarthome.mvc_mvp_mvvm.mvp.inter.IPresenter

// 视图接口，定义了视图的操作
interface IView {
    fun setPresenter(presenter: IPresenter)
    // 数据处理中视图
    fun loading()
    // 数据展示
    fun showData(data: String)
}