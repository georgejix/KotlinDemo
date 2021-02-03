package com.example.jx

import org.junit.Test

class Test2 {
    @Test
    fun test() {
        var a = A(1, 2)
        i = 5
        println(i)

        val b = B("name", 18)
        var (name, age) = b
        println("name = ${name}, age = ${age}")
    }

    var i: Int = 1
        set(value) {
            field = value
        }
        get() = field
}

class A() {
    init {
        println("init")
    }

    constructor(a: Int) : this() {
        println("aa")
    }

    constructor(a: Int, b: Int) : this(a) {
        println("aa bb")
    }
}

data class B(val name: String, val age: Int) {}