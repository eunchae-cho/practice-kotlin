package com.example.demo.coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.future.await
import java.util.concurrent.CompletableFuture

/**
 * suspending function (2)
 *
 * suspend function을 통해 다른 여러 비동기 라이브러리를 활용해 사용 가능
 * */

class Chapter17 {
}

suspend fun main() = runBlocking {
     val result1 = call1()
     val result2 = call2(result1)
    printWithTread(result2)
}

suspend fun call01(): Int {
    return CoroutineScope(Dispatchers.Default).async {
        Thread.sleep(1000)
        100
    }.await()
}

suspend fun call02(num: Int): Int {
    return CompletableFuture.supplyAsync{
        Thread.sleep(1000)
        num * 2
        // await()는 coroutine 상위 클래스에서 여러 비동기 라이브러리에 지원해주는 어댑터
    }.await()
}