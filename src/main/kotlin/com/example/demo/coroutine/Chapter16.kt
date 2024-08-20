package com.example.demo.coroutine

import kotlinx.coroutines.*

/**
 * suspending function (1)
 * */

class Chapter16 {
}

suspend fun main() = runBlocking {
    // async의 응답 타입 존재
    // Java의 CompletableFuture를 쓴다거나 Reactor 같은 다른 비동기 라이브러리를 사용할 때
    // 여파가 main() 함수까지 가게 된다. --> suspend function 활용!
    val result1: Deferred<Int> = async {
        call1()
    }

    val result2 = async {
        call2(result1.await())
    }

    printWithTread(result2.await())
}

fun call1(): Int {
    Thread.sleep(1000)
    return 100
}

fun call2(num: Int): Int {
    Thread.sleep(1000)
    return num * 2
}