package com.smarthome.mvc_mvp_mvvm.mvp

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.smarthome.mvc_mvp_mvvm.mvp.inter.IPresenter
import com.smarthome.mvc_mvp_mvvm.mvp.inter.IView
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  author : Fuwa
 *  e-mail : fufan.zhou@androidmov.com
 *  date   : 2021/5/19 15:41
 *  desc   :
 *  version: 1.0
 */
class TestActivity: AppCompatActivity(), IView {
    var mpresenter: IPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        titleText.text = "NORMAL"
        edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // 传递 文字修改 事件给 Presenter
                mpresenter?.onTextChanged(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        clearText.setOnClickListener {
            // 传递按钮点击事件给 Presenter
            mpresenter?.onClearBtnClicked()
        }
    }

    override fun setPresenter(presenter: IPresenter) {
        this.mpresenter = presenter
    }

    // 展示数据处理中的视图
    override fun loading() {
        msgText.text = "handling data ..."
    }

    // 展示处理后的数据
    override fun showData(data: String) {
        msgText.text = data
    }
}