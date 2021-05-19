package com.smarthome.mvc_mvp_mvvm.mvc.mvc2

import com.smarthome.mvc_mvp_mvvm.mvc.mvc2.inter.IController
import com.smarthome.mvc_mvp_mvvm.mvc.mvc2.inter.IModel

/**
 * 处理逻辑判断， 然后持有model层，让model进行数据访问等处理。
 * @property model IModel?
 */
class HandleController(private var model: IModel) : IController {


    override fun onDataChanged(data: String) {
        model.handleData(data)
    }

    override fun clearData() {
        model.clearData()
    }

}