package com.example.demo.coroutine

import kotlinx.coroutines.*

/**
 * 코루틴의 예외처리
 * launch - 예외가 발생하면, 예외를 출력하고 코루틴이 종료
 * async - 예외가 발생히도, 예외를 출력하지 않음. 예외를 확인하려면, await() 필요
 * */

class Chapter11 {
}

fun main() = runBlocking {
    // CoroutineScope를 통해 root 코루틴을 만든다.
    // 그냥 launch를 사용하게 되면 부모 코루틴인 runBlocking의 종속된 자식 코루틴이다.
//    val job = CoroutineScope(Dispatchers.Default).launch {
//        throw IllegalArgumentException()
//    }
//
//    delay(1000)

    // 루트 코루틴
    // 루트 코루틴이기 때문에 await()를 하지 않으면 Exception이 발생하지 않는다.
    val job = CoroutineScope(Dispatchers.Default).async {
        throw IllegalArgumentException()
    }

    delay(1000)
//    job.await()
}