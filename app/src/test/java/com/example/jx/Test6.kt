package com.example.jx

import com.example.jx.commonobj.Person
import com.example.jx.commonobj.SecondPerson2
import com.example.jx.commonobj.Stu
import com.example.jx.commonobj.testoverride.Dog
import org.junit.Test

class Test6 {
    @Test
    fun test() {
        testClass();
    }

    private fun testClass() {
        var p1 = Person("zhangsan");
        var p2 = Person(17);
        var stu1 = Stu(18);
        var person2 = SecondPerson2(16);
        var dog = Dog();
        dog.eat();
    }
}