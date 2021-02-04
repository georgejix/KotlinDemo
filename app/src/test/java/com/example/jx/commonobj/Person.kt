package com.example.jx.commonobj

//如果主构造函数没有任何注解或者可见性修饰符,可以省略这个 constructor 关键字
//类上的open标注与 Java 中final相反,它允许其他类 从这个类继承。默认情况下,在Kotlin 中所有的类都是 final
open class Person public constructor(var firstName: String) {

    //该处也可使用主构造函数中的变量
    val firstNameT = firstName;

    //主构造函数不能包含任何的代码。初始化的代码可以放 到以init关键字作为前缀的初始化块
    init {
        println("Person.firstName=${firstName}");
        println("Person.firstNameT=${firstNameT}");
    }

    //次构造函数
    //每个次构造函数需要委托给主构造函数, 可以直接委托或者通过别的次构造函数间接委托。委托到同一个类的另一个构造函数 用this关键字即可
    constructor(age: Int) : this("lisi") {
        println("Person.age=${age}");
    }
}