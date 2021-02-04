package com.example.jx.commonobj

//在 Kotlin 中所有类都有一个共同的超类 Any ,这对于没有超类型声明的类是默认超类
class Stu private constructor(){
    /*private constructor() {
        println("Stu.main constructor");
    }*/

    constructor(name: String) : this() {
        println("Stu.name=${name}");
    }

    constructor(age: Int) : this() {
        println("Stu.age=${age}");
    }
}