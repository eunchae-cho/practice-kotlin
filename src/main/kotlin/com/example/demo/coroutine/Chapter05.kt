package com.example.demo.coroutine

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 코루틴과 빌더
 * */
class Chapter05 {
}

// runBlocking -> 코루틴 빌더
fun main() = runBlocking {
    printWithTread("START")

    // launch의 코루틴 결과값이 아니라 코루틴 자체의 오브젝트를 받음
    // CoroutineStart.LAZY
    // -> 지연 시작 모드, 코루틴이 즉시 시작되지 않고 start() 함수나 await 또는 join 함수로 결과를 요청할 때 시작
    // -> 코루틴이 생성되지만, 직접 실행되지 않으며, 명시적으로 시작되기 전까지 대기 상태
    // CoroutineStart.Atomic
    // -> 코루틴이 생성될 때 즉시 시작
    // -> 취소 불가능 상태에서 시작
    // CoroutineStart.Default
    // -> 코루틴이 생성할 때 바로 시작
    // -> 코루틴이 취소될 수 있음
    // CoroutineStart.Undispatched
    // -> 코루틴이 현재 호출 스레드에서 즉시 실행
    // -> 첫번째 일시중단 지점에 도달할 때까지 호출 스레드에서 계속 실행

    val job = launch(start = CoroutineStart.LAZY) {
        printWithTread("Hello Launch")
    }

    printWithTread("job start()")
    // 코루틴 명시적 시작
    // 지연된 코루틴 실행, 즉시 실행
    job.start()

    printWithTread("job join()")
    // 코루틴이 끝날때까지 대기
    job.join()

    printWithTread("END")
}
