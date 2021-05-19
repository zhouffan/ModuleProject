package com.smarthome.mvc_mvp_mvvm.mvc.mvc1

import android.os.Handler
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  author : Fuwa
 *  e-mail : fufan.zhou@androidmov.com
 *  date   : 2021/5/19 16:00
 *  desc   :
 *  version: 1.0
 */
object DataCenter {
    /**
     * 数据的处理，真实情况下可能是网络请求，磁盘存取，大量计算逻辑等等
     * @param data String
     */
    fun handleData(data: String): String {
        return "xxxxxxx ${data}"
    }
}