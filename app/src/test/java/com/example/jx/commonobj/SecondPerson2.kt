package com.example.jx.commonobj

class SecondPerson2 : Person {

    //如果类没有主构造函数,那么每个次构造函数必须 使用Fsuper关键字初始化其基类型
    constructor(age: Int) : super("") {
        println("SecondPerson2.age=${age}");
    }
}