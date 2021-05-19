package com.smarthome.mvc_mvp_mvvm.mvp.inter

// 控制器，定义了逻辑操作
interface IPresenter {
    fun setView(view: IView)
    fun setModel(model: IModel)
    // Model 处理完成数据通知 Presenter
    fun dataHandled(data: String)
    // Model 清除数据后通知 Presenter
    fun dataCleared()
    // View 中 EditText 文字变化后通知 Presenter
    fun onTextChanged(text: String)
    // View 中 Button 点击事件通知 Presenter
    fun onClearBtnClicked()
}