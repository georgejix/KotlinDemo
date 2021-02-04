package com.example.jx.commonobj.testoverride

class Dog : Animal() {
    //显示声明override表示覆盖父类方法
    override fun eat() {
        println("Dog.eat");
    }
}