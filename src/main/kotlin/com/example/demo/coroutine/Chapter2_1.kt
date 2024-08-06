package com.example.demo.coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 루틴과 코루틴의 차이
 * - co-routine: 협력하는 루틴 (=코드 모음)
 * */
class Chapter2_1 {
    suspend fun newRoutineA() {
        val num1 = 1
        val num2 = 2
        println("${num1 + num2}")
    }

    suspend fun newRoutineB() {
        val num1 = 3
        val num2 = 4
        println("${num1 + num2}")
    }
}

fun main() = runBlocking {
    println("START")
    launch {
        println("LAUNCH 1")
        Chapter2_1().newRoutineA()
        println("LAUNCH 2")
        Chapter2_1().newRoutineB()
        println("LAUNCH 3")
    }
    println("END")
}