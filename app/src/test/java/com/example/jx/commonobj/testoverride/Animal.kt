package com.example.jx.commonobj.testoverride

open class Animal {
    //声明成open表示可被覆盖
    open fun eat(){
        println("Animal.eat");
    }
}