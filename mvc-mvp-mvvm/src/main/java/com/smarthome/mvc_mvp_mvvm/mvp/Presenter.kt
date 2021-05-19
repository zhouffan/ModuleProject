package com.smarthome.mvc_mvp_mvvm.mvp

import com.smarthome.mvc_mvp_mvvm.mvp.inter.IModel
import com.smarthome.mvc_mvp_mvvm.mvp.inter.IPresenter
import com.smarthome.mvc_mvp_mvvm.mvp.inter.IView

class Presenter : IPresenter {
    private var model: IModel? = null
    private var view: IView? = null

    override fun setModel(model: IModel) {
        this.model = model
    }

    override fun setView(view: IView) {
        this.view = view
    }

    override fun dataHandled(data: String) {
        view?.showData(data)
    }

    override fun dataCleared() {
        view?.showData("")
    }

    override fun onTextChanged(text: String) {
        view?.loading()
        model?.handleData(text)
    }

    override fun onClearBtnClicked() {
        model?.clearData()
    }
}