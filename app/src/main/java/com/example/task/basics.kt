package com.example.task

fun main(){
    var name:String="Sandis"
    var age:Int=10
    var terms:Boolean=false
    println("The name and age is $name and $age");

    var ages=arrayOf<Int>(10,20)
    println("The first element is ${ages[0]}")
    println("The second element is ${ages[1]}")

    var agess= arrayListOf<Int>(1,2,3)
    agess.add(50)
    println("The arrayListOf $agess")

    var a=ArrayList<Int>();
    a.add(20)
    a.add(0)
    println("ArrayList ${a[1]}")

    var b= arrayOf<Any>(1,1.2,"abc",'d')
    println("Any ${b[2]}")
}
