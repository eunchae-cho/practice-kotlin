package com.example.demo.coroutine

import kotlinx.coroutines.*

/**
 * 코루틴의 예외처리
 *
 * 예외 처리 방법 (1) - 직관적인 try-catch-finally
 * */

class Chapter13 {
}

fun main() = runBlocking {
    val job = launch {
        try {
            throw IllegalArgumentException()
        } catch (e: IllegalArgumentException) {
            println("정상 종료")
        }
    }
    delay(1000)
}