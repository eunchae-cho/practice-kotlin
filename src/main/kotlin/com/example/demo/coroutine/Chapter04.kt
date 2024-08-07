package com.example.demo.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 코루틴과 빌더
 * */
class Chapter04 {
}

// runBlocking -> 코루틴 빌더
fun main() {
    runBlocking {
        printWithTread("START")
        launch {
            delay(2_000L)
            printWithTread("LAUNCH END")
        }
    }

    printWithTread("END")
}

// 실행 결과
// START
// LAUNCH END
// END

fun printWithTread(value: Any) {
    println("[${Thread.currentThread().name}] $value")
}