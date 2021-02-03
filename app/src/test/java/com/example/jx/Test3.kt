package com.example.jx

import org.junit.Test

class Test3 {
    @Test
    fun t1() {
        println("sum1" + sum1(2, 3));
        println("sum2" + sum2(Array(2) { it + 6 }));
        sum3(1, 2);
        println("sum4" + sum4(5, 6));
        println("sum 1 to 4=${sum2(Array(4) { it + 1 })}");
        定义局部变量();
        字符串表达式();
        println("abcde.length = ${getStringLength("abcde")}");
        循环();
        println("1 is ${when判断("1")}");
        range区间();
    }

    private fun sum1(a: Int, b: Int): Int {
        return a + b;
    }

    private fun sum2(a: Array<Int>): Int {
        var sum: Int = 0;
        for (i in a) {
            sum += i;
        }
        return sum;
    }

    //Unit可省略
    private fun sum3(a: Int, b: Int): Unit {
        println(a + b);
    }

    private fun sum4(a: Int, b: Int) = a + b;

    private fun 定义局部变量() {
        //只读变量
        val a: Int = 1;
        val b = 2;  // 自动推断出 `Int` 类型
        val c: Int;  // 如果没有初始值类型不能省略
        c = 3;

        //可变变量
        var aR: Int = 1;
        aR += 1;
        println("aR = ${aR}");
    }

    private fun 字符串表达式() {
        println("max of 5 , 9 is ${maxOf(5, 9)}");
        //简化if else
        var a = if (5 > 6) 5 else 6;
        println("a=${a}");
    }

    //可空变量
    private fun parseInt(str: String): Int? {
        return str.toIntOrNull();
    }

    //is
    private fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length;
        }
        return null;
    }

    private fun 循环() {
        //for循环
        val items = listOf("a", 1, "b", 2, "c");
        for (item in items) {
            println(item);
        }
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }

        //while循环
        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }
    }

    //when
    private fun when判断(obj: Any): String {
        return when (obj) {
            "1" -> "One"
            "2" -> "Two"
            "3" -> "Three"
            else -> "Null"
        }
    }

    private fun range区间() {
        val a = 5;
        val b = 7;
        //使用in运算符来检测某个数字是否在指定区间内
        if (a in 1..b) {
            println("a in ${1..b}");
        }
        //检测某个数字是否在指定区间外
        if (99 !in 1..b) {
            println("99 !in ${1..b}");
        }
        //区间迭代
        for (i in 1..5) {
            print("${i},");
        }
        println();
        //区间迭代
        for (i in 1..5 step 2) {
            print("${i},");
        }
        println();
        for (i in 9 downTo 0 step 2) {
            print("${i},");
        }
        println();
        //对集合进行迭代
        val list1 = listOf("a", "b", "cc");
        for (i in list1) {
            print("${i},");
        }
        println();
        //list + when
        val set1 = setOf("a", "b", "c");
        when {
            "a" in set1 -> println("a in set1")
            "123" !in set1 -> println("123 not in set1")
        }
        //使用 lambda 表达式来过滤(filter)和映射(map)集合
        val fruits = listOf("banna", "apple", "orange", "avocado");
        fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { print("${it},") }
        println();
        //或者
        fruits.filter { x -> x.startsWith("a") }
            .sortedBy { x -> x }
            .map { x -> x.toUpperCase() }
            .forEach { x -> print("${x},") }
        println();
    }
}