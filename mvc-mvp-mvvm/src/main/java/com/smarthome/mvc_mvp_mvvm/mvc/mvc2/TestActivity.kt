package com.smarthome.mvc_mvp_mvvm.mvc.mvc2

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.smarthome.mvc_mvp_mvvm.mvc.mvc2.inter.IController
import com.smarthome.mvc_mvp_mvvm.mvc.mvc2.inter.IModel
import com.smarthome.mvc_mvp_mvvm.mvc.mvc2.inter.IView
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  author : Fuwa
 *  e-mail : fufan.zhou@androidmov.com
 *  date   : 2021/5/19 15:41
 *  desc   :
 *  version: 1.0
 */
class TestActivity: AppCompatActivity(), IView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        titleText.text = "NORMAL"
        edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // 通知 Controller 输入的数据产生变化
                controller.onDataChanged(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        clearText.setOnClickListener {
            // 通知 Controller 清空数据事件
            controller.clearData()
        }
    }

    private var controller: IController = HandleController(HandleModel(this))

    // Model 数据变化，进行界面更新
    override fun onDataHandled(data: String) {
        if (TextUtils.isEmpty(data)) {
            edit.setText("")
            msgText.text = "default msg"
        } else {
            msgText.text = data
        }
    }

    // Model 数据变化，进行界面更新
    override fun dataHanding() {
        msgText.text = "handle data ..."
    }

    override fun setController(controller: IController) {
        this.controller = controller
    }
}