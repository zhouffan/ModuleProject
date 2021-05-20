package com.smarthome.kotlin_learn

import kotlin.reflect.KClass

/**
 *  author : Fuwa
 *  e-mail : fufan.zhou@androidmov.com
 *  date   : 2021/5/20 16:32
 *  desc   :
 *  version: 1.0
 */
class Simple02 {
}

fun main() {
    val name: String? = null
    testMethod().myRunOk {
        //回调方法是泛型的
        true
    }
    //方法体返回的是 this:String， 因为 '万能泛型.'
    name?.myRunOk {
            it-> print(it)
        print("$length")
        false
    }
    //方法体里面没有对象
    name.myRunOk2 {
        it-> print(it)
        true
    }

    //`::` 拿到函数类型的对象
    val m1 = ::testMethod
    test01(m1)

    //无限链式调用
    name.myAlso {

    }.myAlso {

    }.myAlso {

    }

    ktrun() {
        println("执行了一次 x")
    }
}


fun testMethod(){
    print("xxx")
}

fun test01(mm: ()->Unit){
    mm()
}

// 自定义线程封装
fun ktrun(
    start: Boolean = true,
    name: String ? = null,
    myRunAction: () -> Unit) : Thread {
    val thread = object : Thread() {
        override fun run() {
            super.run()
            myRunAction()
        }
    }
    name ?: "DerryThread"
    if (start)
        thread.start()
    return thread
}

/**
 * 高阶函数：
 * @receiver 万能泛型   随意定义
 * @param mm [@kotlin.ExtensionFunctionType] Function1<万能泛型, Boolean>
 *     ‘万能泛型.()->Boolean’  ：回调方法是泛型的
 */
fun <万能泛型> 万能泛型.myRunOk(mm: 万能泛型.(Int)->Boolean){
    mm(10)
}
fun <万能泛型> 万能泛型.myRunOk2(mm: (Int)->Boolean){
    mm(10)
}
//R：返回泛型
fun <T, R> T.myRun(mm: ()->R):R{
    return mm()
}
fun <T, R> T.myLet(mm: T.(T) -> R): R {
    // T == this   () -> R
    // mm(this) == this     vs    T.(T)  -> R
    return mm(this)
}

//返回this， 可以无限链式调用
fun <T> T.myAlso(mm: (T) -> Unit) : T{
    // T == this
    // it == T == this == name
    mm(this)
    return this
}