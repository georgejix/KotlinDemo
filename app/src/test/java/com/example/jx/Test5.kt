package com.example.jx

import org.junit.Test
import com.example.jx.commonobj.a.A;
//如果出现名字冲突,可以使用as关键字在本地重命名冲突项来消歧义
import com.example.jx.commonobj.b.A as bA;

class Test5 {
    @Test
    fun test() {
        testNumber();
        testArray();
        testString();
        test同名类导入();
        testIf();
        testWhen();
        testFor();
        testWhile();
        testLabel();
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

        //arrayOfNulls()可以用于创建一个指定大小、元素都为空的数组
        var array2 = arrayOfNulls<Int>(3);
        printArray(array2);

        //另一个选项是用接受数组大小和一个函数参数的工厂函数,用作参数的函数能够返回 给定索引的每个元素初始值
        var array3 = Array(5, { i -> (i + 2).toString() });
        printArray(array3);

        var array4 = Array(3) { i -> i.toString() };
        printArray(array4);

        //无装箱开销的数组对象
        var array5 = intArrayOf(1, 2, 3);
    }

    private fun testString() {
        var a = "this is a string";
        for (c in a) {
            print("${c},")
        }
        println()
        //字符串用下标索引
        println(a[2]);
        //可以通过trimMargin()函数去除前导空格
        var b = """
            this
            is
            a
            string
        """.trimIndent()
        println(b);
        //这样打印一个$符号
        println("${'$'}");
    }

    private fun test同名类导入() {
        var a1 = A();
        var a2 = bA();
        a1.pr();
        a2.pr();
    }

    private fun testIf() {
        //if可以作为表达式，也可作为语句
        //if作为表达式而不是语句(例如:返回它的值或者 把它赋给变量),该表达式需要有else分支
        var a = if (5 > 6) 5 else 6;
        var b: Int;
        if (5 > 6) {
            b = 5;
        } else {
            b = 6;
        }
    }

    private fun testWhen() {
        //when可当做表达式，或者语句
        //when作为表达式，必须要有else分支,除非把所有情况都覆盖
        var a = 1;
        var b = when (a) {
            1 -> "one"
            2 -> "two"
            else -> "other"
        }
        //如果很多分支需要用相同的方式处理,则可以把多个分支条件放在一起,用逗号分隔
        when (a) {
            1, 3 -> b = "one"
            2 -> b = "two"
            else -> b = "else"
        }
        //我们可以用任意表达式(而不只是常量)作为分支条件
        when (a) {
            1, 3 -> b = "one"
            "3".toInt() -> b = "two"
            else -> b = "else"
        }
        //也可以检测一个值在(in)或者不在(!in)一个区间或者集合中
        when (a) {
            in 1..10 -> println("x is in the range")
            !in 10..20 -> println("x is outside the range")
            else -> println("none of the above")
        }
        //检测一个值是(is)或者不是(!is)一个特定类型的值
        var c: Any = "prefix23";
        val hasPrefix = when (c) {
            is String -> c.startsWith("prefix")
            else -> false
        }
        println(hasPrefix);
        //when也可以用来取代if - else if
        when {
            a == 1 -> println("a == 1")
            a != 1 -> println("a != 1")
            else -> println("error")
        }
    }

    private fun testFor() {
        var a = intArrayOf(1, 2, 3, 4, 5);
        for (item in a) {
            print("${item},")
        }
        println()
        for (index in a.indices) {
            print("${a[index]},")
        }
        println()
        for ((index, value) in a.withIndex()) {
            print("a[${index}]=${value},")
        }
        println()
    }

    private fun testWhile() {
        var a: Int = 5;
        while (a > 0) {
            print("${a},")
            a--;
        }
        println()
        a = 5;
        do {
            print("${a},")
            a--;
        } while (a > 0)
        println()
    }

    private fun testLabel() {
        //标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点
        labelA@ for (i in 1..100) {
            for (j in 1..100) {
                print("${i}-${j},");
                if (2 == j) {
                    break@labelA
                }
            }
        }
        println()

        //return标签只会return标签所在函数
        var array1 = intArrayOf(1, 2, 3, 4, 5);
        array1.forEach labelB@{
            if (it == 2) {
                return@labelB
            } else {
                print("it=${it},")
            }
        }
        println()
        println("print array1 finish");

        //return label带有返回值用法：return@a 1,意为“从标签@a返回 1”
    }
}