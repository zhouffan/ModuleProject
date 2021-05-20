package com.smarthome.kotlin_learn

import kotlin.reflect.KClass

/**
 *  author : Fuwa
 *  e-mail : fufan.zhou@androidmov.com
 *  date   : 2021/5/20 16:32
 *  desc   :
 *  version: 1.0
 */
class Simple01 {
}

fun main() {
    val stu2 =  Student2(4545, "Derry", 'M')
    val (v1, v2, v3) = stu2.copy()
    //自定义解构赋值
    val stu =  Student(4545, "Derry", 'M')
    val(n1, n2, n3 ,n4) = stu

    stu.show("")

    `123`()
    showClass(KtStudent::class)
    showClass2(Thread::class.java)

    val instance = SingleInstance.getInstance()
    specialStr()
    lenMethod("222","333","444")
}

//扩展函数
fun Student.show(string: String){
    println(string)
}

//自定义解构赋值
data class Student2(var id: Int, var name: String ,var sex: Char)
class Student(var id: Int, var name: String ,var sex: Char){
    // component 不能写错
    operator fun component1(): Int = id
    operator fun component2(): String = name
    operator fun component3(): Char = sex
    operator fun component4(): String = "KT Study OK"

    //运算符重载   student + student
    operator fun plus(num: Int): Int{
        return id + num
    }

}

//特殊名称方法
fun `123`(){
    print("xx")
}

//kotlin类 KtStudent
fun showClass(clazz: KClass<KtStudent>){}
//java类  thread
fun showClass2(clazz: Class<Thread>){}
class KtStudent{}

/**
 * 可变参数
 * @param names Array<out String>
 */
fun lenMethod(vararg names: String){
    names.forEach {
        println(it)
    }
}

fun specialStr(){
    // --- 自己不用关系 \n 换行 ，不用自己调整
    val infoMesage = """
        AAAAAAAAAAA
        BBBBBBBBBBB 
    """  // 前置空格
    println(infoMesage)

    val infoMesage2 = """
        AAAAAAAAAAA
        BBBBBBBBBBB 
    """.trimIndent()  // 没空格
    println(infoMesage2)

    val infoMesage3 = """
        ?AAAAAAAAAAA
        ?BBBBBBBBBBB 
    """.trimMargin("?")  // 没空格 控制|
    println(infoMesage3)

    // 需求：显示 $99999.99
    val price = """
        ${'$'}99999.99
    """.trimIndent()
    println(price)
}

fun forMethod(){
    for(i in 1..10){
        println(i)
    }
    for (i in 9 downTo 1){
        println(i)
    }
    for (i in 1 until 30 step 2 ){
        println(i)
    }
}

fun forTag(){
    //自定义标签
    aaa@for ( i in 1..10){
        for (j in 1..10){
            if(j == 3){
//                break//停止最近循环
                break@aaa
            }
        }
    }
}

fun otherMethod(){
    // ---  比较对象地址
    val test1:Int? =  10000
    val test2:Int? =  10000
    println(test1 === test2) // false

    val num = if (test1 == 1) {
        false
    } else {
        true
    }

    when (test1) {
        1000 -> println("sss")
        in 1..20 -> println("222")
    }
}


class Person(id: Int){//主构造
    //次构造
    constructor():this(-1){}
    //次构造
    constructor(id: Int, name:String):this(id){}
}

class Sub{
    val num: Int = 1
    //嵌套类
    class Sub1{
//        val s = num
    }
    //内部类
    inner class Sub2{
        val s = num
    }

}

class SingleInstance{
    //object 单例
    object Holder{
        val instance = SingleInstance()
    }
    companion object{
        //对外提供方法
        fun getInstance() = Holder.instance
    }
}