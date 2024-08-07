package com.example.demo.coroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * 코루틴과 빌더
 * async
 * -> callback을 이용하지 않고 동기 방식으로 코드를 작성할 수 있다. (콜백 지옥 x)
 * */
class Chapter07 {
}

// runBlocking -> 코루틴 빌더
fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val job1 = async { apiCall1() }
//        val job2 = async { apiCall1() }
//        printWithTread("${job1.await()}, ${job2.await()}")
//    }
//    // 실행 시간 측정
//    printWithTread(time)

    val time = measureTimeMillis {
        val job1 = async { apiCall1() }
        val job2 = async { apiCall2(job1.await()) }
        printWithTread(job2.await())
    }
    // 실행 시간 측정
    printWithTread(time)
}

suspend fun apiCall1(): Int {
    delay(1000L)
    return 1
}

suspend fun apiCall2(num: Int): Int {
    delay(1000L)
    return 2
}