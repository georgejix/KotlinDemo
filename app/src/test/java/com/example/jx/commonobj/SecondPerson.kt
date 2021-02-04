package com.example.jx.commonobj

class SecondPerson(firstName: String) : Person(firstName) {
    constructor(age: Int) : this("") {
        println("SecondPerson.age=${age}");
    }
}