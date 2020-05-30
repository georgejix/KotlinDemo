package com.example.jx

import android.content.Context
import android.service.autofill.Validators.and
import android.service.autofill.Validators.or
import com.example.jx.tools.LogUtil

class Test {
    private val TAG = "Test"
    fun startTest(context: Context) {
        LogUtil.logd(TAG, "start test")
        printSum(1, 2)
        vars(1, 2, 3, 4, 5)
        testStep()
        testNum()
        array()
    }

    fun sum(a: Int, b: Int): Int? {
        println("sum")
        return a + b
    }

    fun sum2(a: Int, b: Int) = a + b

    //public必须显示写出返回值类型
    public fun sum3(a: Int, b: Int): Int = a + b

    //无返回值，写为Unit，也可不显示写出
    fun printSum(a: Int, b: Int): Unit {
        println("printSum")
        println("$a + $b = ${a + b}")
    }

    //可变长度数组
    fun vars(vararg v: Int) {
        println("vars")
        for (i in v) {
            println(i)
        }
    }

    //lambda表达式
    val lambdaSum: (Int, Int) -> Int = { x, y -> x + y }

    //可变变量
    var a = "a"

    //不可变常量
    val b = "b"

    fun test1() {
        println("test1")
        //后面加? 表示值可以是null
        var age: String? = null

        //会报空指针异常
        val ages = age!!.toInt()

        //不做处理返回 null
        val ages1 = age?.toInt()
        println("ages1 = $ages1")

        //age为空返回-1
        val ages2 = age?.toInt() ?: -1
        println("ages2 = $ages2")

    }

    //is 类似java的instance of
    fun getStringLength(obj: Any): Int? {
        println("getStringLength")
        if (obj is String) {
            return obj.length
        }
        return null
    }

    fun testStep() {
        println("testStep")
        for (i in 1..5) print(i)    //等价于java的for(int i = 1; i <= 5; i++)
        println("")
        for (i in 1..5 step 3) print(i)
        println("")
        for (i in 4 downTo 1 step 2) print(i)        //downTo倒序，step步长
        println("")
        for (i in 1 until 4) print(i)        //[1,4),不包含4
        println("")
    }

    fun testNum() {
        println("testNum")
        val a = 10_000      //数字中间可以加上下划线
        println("a = $a")
        val b = 1L
        val c = 0xFF        //16进制
        val d = 0b1001      //2进制
        val e = 1.01f

        val f: Int = 1000
        val g: Int? = f
        val h: Int? = f
        //由Int到Int?会进行装箱
        println("g==h ${g == h}")       //比较值
        println("g===h ${g === h}")     //比较地址

        val i: Byte = 1
        val j: Int = i.toInt()   //要显示强转，不能够自动进行类型转换
        val k = 3L + 2f     //此场景可以自动类型转换
        val l: Char = 'c'    //Char需要有单引号
        //if(l == 2)    错误，Char不可以直接和Int作比较

        val m: Int = 199
        println(m.shl(2)) //左移位 (Java’s <<)
        println(m.shr(2))   //右移位 (Java’s >>)
        println(m.ushr(2)) //无符号右移位 (Java’s >>>)
        println(m.and(2)) //与
        println(m.or(2)) //或
        println(m.xor(2)) //异或
        println(1.inv()) //取反
    }

    fun decimalDigitValue(c: Char): Int {
        println("decimalDigitValue")
        if (c !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        return c.toInt() - '0'.toInt() // 显式转换为数字
    }

    fun array() {
        println("array")
        val a = arrayOf(1, 2, 3)
        val b = Array(3) { i -> i * 2 }
        println(b[2])
        for (c in b) {
            println(c)
        }
        val d = """
            a
            b
            c
            d
            e
        """
        println(d)
        val e = """
            a
            b
            c
            d
            e
        """.trimIndent()
        println(e)
        val f = "zifuchuan"
        val g = "$f length = ${f.length}"
        println(g)
    }
}
