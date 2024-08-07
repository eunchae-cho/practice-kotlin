package com.example.demo.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 코루틴과 빌더
 * */
class Chapter06 {
}

// runBlocking -> 코루틴 빌더
fun main() = runBlocking {
    val job1 = launch {
        delay(1000L)
        printWithTread("Hello Launch Job1")
    }
    // 코루틴이 완료될 때까지 대기
    // job1의 코루틴이 끝날 때까지 대기
//    job1.join()

    val job2 = launch {
        delay(1000L)
        printWithTread("Hello Launch Job2")
    }

}