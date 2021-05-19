package com.smarthome.mvc_mvp_mvvm.mvp.inter

// 模型接口，定义了数据模型的操作
interface IModel {
    fun setPresenter(presenter: IPresenter)
    // 梳理数据
    fun handleData(data: String)
    // 清除数据
    fun clearData()
}