package com.smarthome.mvc_mvp_mvvm.mvc.mvc2.inter

/**
 * 数据模型接口，定义了数据模型的操作
 *
 * 持有view， 请求数据，清理数据。并通知view层
 */
interface IModel {
    // 数据模型处理输入的数据
    fun handleData(data: String)
    // 清空数据
    fun clearData()
}