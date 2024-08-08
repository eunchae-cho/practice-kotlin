package com.example.demo.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * 코루틴 취소
 * -> 여러 코루틴을 사용할 때 필요없어진 코루틴을 적절하게 취소해서 컴퓨팅 자원을 아껴야 한다.
 *
 * 코루틴 취소 방법 (2) - 코루틴 스스로 본인의 상태를 확인해 취소 요청을 받았으면, cancellationException 던지기
 *
 * 사실 delay() 같은 함수도 cancellationException 함수를 사용하고 있다.
 *
 * -> case 1. 발생한 예외가 CancellationException인 경우 취소로 간주하고 부모 코루틴에게 전파 x
 * -> case 2. 이 외 다른 예외가 발생한 경우 실패로 간주하고 부모 코루틴한테 전파
 * but) 내부적으로는 취소나 실패 모두 취소됨으로 간주한다.
 * */
class Chapter10 {
}

fun main() = runBlocking {
    // Dispatchers.Default 선언으로 이 코루틴은 main 스레드와 별개의 스레드로 동작한다.
    // 다른 스레드로 배정!
    val job = launch(Dispatchers.Default) {
        var i = 1
        var nextPrintTime = System.currentTimeMillis()
        while (i <= 5) {
            if (nextPrintTime <= System.currentTimeMillis()) {
                printWithTread("${i++}번째 출력")
                nextPrintTime += 1000L
            }

            // 해당 launch에 의한 코루틴이 현재 취소 명령을 받았는지 아니면 여전히 활성화 상태인지 알 수 있음
            if(!isActive) {
                throw CancellationException()
            }
        }
    }

    delay(100L)
    job.cancel()
}
