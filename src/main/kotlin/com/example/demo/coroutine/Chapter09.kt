package com.example.demo.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * 코루틴 취소
 * -> 여러 코루틴을 사용할 때 필요없어진 코루틴을 적절하게 취소해서 컴퓨팅 자원을 아껴야 한다.
 *
 * 코루틴 취소 방법 (1) - delay(), yield() 같은 kotlinx.coroutines 패키지의 suspend 함수 사용
 *
 * */
class Chapter09 {
}

fun main() = runBlocking {
    val job = launch {
        var i = 1
        var nextPrintTime = System.currentTimeMillis()
        while (i <= 5) {
            if (nextPrintTime <= System.currentTimeMillis()) {
                printWithTread("${i++}번째 출력")
                nextPrintTime += 1000L
            }
        }
    }

    delay(100L)
    job.cancel()
}


// job1 취소됨
fun example1() = runBlocking {
    val job1 = launch {
        delay(1000L)
        printWithTread("Job 1")
    }

    val job2 =  launch {
        delay(1000L)
        printWithTread("Job 2")
    }

    delay(100)
    job1.cancel()
}
