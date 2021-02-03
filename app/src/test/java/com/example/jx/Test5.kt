package com.example.jx

import org.junit.Test

class Test5 {
    @Test
    fun test() {
        testNumber();
        testArray();
    }

    private fun testNumber() {
        var a = 123_456_789;
        println("a=${a}");

        //自动装箱，不是同一对象
        val b = 1000;
        var c: Int? = b;
        var d: Int? = b;
        println("c==d:${c == d}");
        println("c===d:${c === d}");

        //报错
        //var e:Long? = b;

        var f: Byte = 1;    //字面值是静态检测的
        var g: Int = f.toInt(); //显式拓宽
        var h = 1L + 2; // Long + Int => Long

        /*
        * 这是完整的位运算列表(只用于Int和Long
            shl(bits) – 有符号左移 (Java 的 << )
            shr(bits) – 有符号右移 (Java 的 >> )
            ushr(bits)– 无符号右移 (Java 的>>> )
            and(bits)– 位与
            or(bits)– 位或
            xor(bits)– 位异或
            inv()– 位非
        * */

        //字符用Char类型表示。它们不能直接当作数字
    }

    private fun decimalDigitValue(c: Char): Int {
        if (c !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        return c.toInt() - '0'.toInt() // 显式转换为数字
    }

    /* 内置的布尔运算有:
        || – 短路逻辑或
        && – 短路逻辑与
        !- 逻辑非
    */

    private fun <T : Any?> printArray(array: Array<T>) {
        for (item in array) {
            print("item=${item},")
        }
        println()
    }

    private fun testArray() {
        var array1 = arrayOf(1, 2, 3);
        printArray(array1);
        var array2 = arrayOfNulls<Int>(3);
        printArray(array2);
    }
}