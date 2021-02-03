package com.example.jx.data

//extra默认参数，不传参就是默认值
data class DataA(var age: Int, var name: String, var score: Double, var extra: String = "extra") {
    fun fun1() {
        println("age=${age}")
    }

    fun fun2() {
        println("name=${name}")
    }

    fun fun3() {
        println("score=${score}")
    }
}