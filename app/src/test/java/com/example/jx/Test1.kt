package com.example.jx

import org.junit.Test

class Test1 {
    var mA: String = "a"
        get() = "$field,get"
        set(value) {
            field = "$field.."
        }
    lateinit var mB: String;//编译器会认为这个变量一定在某个时刻被初始化，具体什么时候被初始化，自己写

    @Test
    fun test() {
        val array1 = Array(3) { i -> i * 3 };
        printArray(array1)
        val array2 = arrayOf(1, "2", "c");
        printArray(array2)
        println("${'$'}")
        println(mA)
        mB = "mB"
        println(mB)
        var aa = A();
        aa.foo();
        setTT(object : IA {
            override fun tt() {
                println("tt")
            }
        })
    }

    class CC<T, K>(c:T, cc:K){

    }

    interface IA {
        fun tt();
    }

    fun setTT(tt: IA) {
        tt.tt();
    }

    inner class A {
        fun foo() {
            var v = this@Test1;//获取外部类对象
            println(v.mA)
        }
    }

    fun <T> printArray(array: Array<T>) {
        for (a in array) {
            print("${a} ");
        }
        for (index in array.indices) {
            print("${array[index]} ")
        }
        println();
    }
}