package com.example.jx

import com.example.jx.a.A
import com.example.jx.b.A as bA
import org.junit.Test
import java.io.File

class Test1 {
    @Test
    fun t1() {
        fun0()
        //fun1("2")
        //fun2()
    }

    private fun fun0() {
        val list1 = listOf("aca", "abb", "cc")
        list1.filter { x -> x.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

        val map1 = mapOf("a" to 1, "b" to 2, "c" to 3)
        for ((k, v) in map1) {
            println("$k->$v")
        }
        println(map1["a"])

        var string2 = "s1"
        val string1: String by lazy {
            string2
        }
        string2 = "s2"
        println(string1)

        val file1 = File("Test").listFiles()
        println(file1?.size)    //if not null
        println(file1?.size ?: "empty")     //if not null and else
        println(file1 ?: "empty")       //if null

        println(transform("Red"))
        val aa = file1 ?: return
        println(transform("Green"))

    }

    private fun transform(color: String): Int {
        println("--------transform-------")
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }

    private fun fun1(param: String) {
        println("--------fun1-------")
        var a = if ("2" == param) {
            2
        } else if ("3" == param) {
            3
        } else {
            4
        }
        println(a)

        val b = try {
            3
        } catch (e: Exception) {
        }
        println(b)

        val c = IntArray(5).apply { fill(-1) }
        println(c[0])

        val d = 15__23
        println(d)

        val e: IntArray = intArrayOf(1, 2, 3)
        println(e[2])
        val f: Array<Int?> = arrayOfNulls<Int?>(6)
        println(f[0])

        val g: String = "abcdef"
        for (c in g) {
            println(c)
        }
        println(g[2])

        val h = """
            this is a
                string
        """.trimIndent()
        println(h)

    }

    private fun fun2() {
        var a: com.example.jx.a.A = com.example.jx.a.A()
        println(a.a)
        var b: com.example.jx.b.A = com.example.jx.b.A()
        println(b.a)
        var c: A = A()
        println(c.a)
        var d: bA = bA()
        println(d.a)

        var e = when (a.a) {
            5 -> {
                1
                2
            }
            in 6..7 -> {
                3
                4
            }
            else -> {
                5
            }
        }
        println(e)
    }

}