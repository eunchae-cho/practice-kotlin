package com.example.demo.coroutine

import kotlinx.coroutines.*

/**
 * 코루틴의 예외처리
 * launch - 예외가 발생하면, 예외를 출력하고 코루틴이 종료
 * async - 예외가 발생히도, 예외를 출력하지 않음. 예외를 확인하려면, await() 필요
 *
 * 만약 자식 코루틴의 예외를 부모에게 전파하고 싶지 않다면?
 * -> SupervisorJob() 사용
 * */

class Chapter12 {
}

fun main() = runBlocking {
    // 루트 코루틴이 아닌 자식 코루틴이기 때문에 await()를 쓰지 않아도 Exception이 발생한다.
    // async에서 발생된 예외가 부모 코루틴에게 전파되기 때문
    val job = async() {
        throw IllegalArgumentException()
    }

    // SupervisorJob()을 통해 부모 코루틴에게 예외를 발생하지 않는다.
//    val job = async(SupervisorJob()) {
//        throw IllegalArgumentException()
//    }

    delay(1000)
}