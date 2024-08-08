package com.example.demo.coroutine

import kotlinx.coroutines.*

/**
 * 코루틴의 예외처리
 *
 * 예외 처리 방법 (2) - CoroutineExceptionHandler
 * try-catch-finally 와 달리 예외 발생 이후 에러 로깅 / 에러 메세지 전송 등에 활용
 *
 * 주의 사항
 * -> launch 에서만 사용 가능
 * -> 부모 코루틴이 존재하면 동작하지 않는다.
 * */

class Chapter14 {
}

fun main() = runBlocking {
    // 예외가 발생해서 로깅이나 에러메세지 전송에 활용
    val exceptionHandler = CoroutineExceptionHandler{_, _ ->
        println("예외 처리")
    }
    val job = CoroutineScope(Dispatchers.Default).launch(exceptionHandler) {
        throw IllegalArgumentException()
    }

    delay(1000)
}