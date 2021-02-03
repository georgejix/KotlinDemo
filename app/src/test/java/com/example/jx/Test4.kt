package com.example.jx

import com.example.jx.data.DataA
import com.example.jx.obj.ObjA
import org.junit.Test
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Paths.*

class Test4 {
    @Test
    fun test() {
        testDataClass();
        println("1 is ${testType(1)}");
        testMap();
        拓展函数();
        单例();
        测试空();
        if表达式(1);
        testArray(3);
        println("red is ${单表达式简化函数("red")}");
        testWith();
        testInputStream();
    }

    private fun testDataClass() {
        var zs = DataA(18, "zhangsan", 98.5);
        println("${zs.name},${zs.extra}");
    }

    private fun testType(x: Any): String {
        return when (x) {
            is String -> "String"
            is Int -> "Int"
            else -> "unknown"
        }
    }

    private fun testMap() {
        var map1 = mapOf("key1" to "a", "key2" to "b");
        for ((k, v) in map1) {
            println("key=${k},value=${v}");
        }
        println("map1.key1 = ${map1["key1"]}");
        //闭区间:包含3
        for (i in 1..3) {
            print("i=${i},");
        }
        println()
        //半开区间:不包含3
        for (i in 1 until 3) {
            print("i=${i},");
        }
        println()
        //lazy变量，初始化时，不会对lazy进行初始化，在变量被使用时才进行初始化
        val c: String by lazy {
            println("get c");
            "123" + "2"
        }
        println(c)
        println(c)
    }

    private fun 拓展函数() {
        fun String.kkk(): String {
            return "11111";
        }
        println("s".kkk());
    }

    private fun 单例() {
        ObjA.a = "2";
        println("ObjA.a=${ObjA.a}");
    }

    private fun 测试空() {
        //if not null缩写
        var files = File("Test").listFiles();
        println("files.size=${files?.size}");

        //if not null and else缩写
        println("files.size=${files?.size ?: "empty"}");

        //if null
        println("files.size=${files ?: "empty"}");

        //if not null执行代码
        var a = 1;
        a?.let { println("a is not null") }
    }

    private fun 异常处理() {
        try {
            var a = 1;
        } catch (e: Exception) {

        }
    }

    private fun if表达式(param: Int) {
        var result = if (1 == param) {
            "one"
        } else if (2 == param) {
            "two"
        } else {
            "other"
        }
        println("param=${result}");
    }

    //返回类型为 Unit 的方法的 Builder 风格用法
    private fun testArray(size: Int): IntArray {
        return IntArray(size).apply { fill(2) }
    }

    //单表达式函数
    private fun 单表达式函数() = 42;

    //等价于
    private fun 单表达式函数2(): Int {
        return 42;
    }

    //单表达式简化函数
    private fun 单表达式简化函数(color: String): Int = when (color) {
        "red" -> 1
        "green" -> 2
        "white" -> 3
        else -> 0
    }

    //对一个对象实例调用多个方法 ( with )
    private fun testWith() {
        var data = DataA(18, "zhangsan", 79.5);
        with(data) {
            fun1()
            fun2()
            fun3()
        }
    }

    private fun testInputStream() {
        val stream = Files.newInputStream(
            get("/home/georgejx/develop/code/mine/KotlinDemo/app/src/test/java/com/example/jx/text1")
        )
        stream.buffered().reader().use { reader ->
            println(reader.readText())
        }
    }

    private fun 可空boolean() {
        var a: Boolean? = null;
    }
}