package com.example.demo.coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 * 루틴과 코루틴의 차이
 * - co-routine: 협력하는 루틴 (=코드 모음)
 * */
class Chapter02 {
    // suspend fun () - 다른 suspend fun() 호출
    suspend fun newRoutine() {
        val num1 = 1
        val num2 = 2
        printWithTread("newRoutine yield()")
        // 지금 코루틴을 중단하고 다른 코루틴이 실행되도록 한다.
        // = 양도한다.
        // 여기서 멈추고 양보한다.
        // 메모리 관점에서 보면, 새로운 루틴이 호출된 후 완전히 종료되기 전
        // 해당 루틴에서 사용했던 정보들을 보관하고 있어야 한다.
        yield()
        printWithTread("${num1 + num2}")
    }
}

// runBlocking -> 코루틴 세계로 연결, 함수 자체로 새로운 코루틴을 만든다.
// blocking이 풀릴 때까지 스레드를 block 한다.
fun main() = runBlocking {
    printWithTread("START")
    // launch - 반환값이 없는 코루틴을 만든다.
    // 만들어진 코드를 바로 실행하지 않고 넘어간다.
    launch {
        Chapter02().newRoutine()
    }
    printWithTread("main yield()")
    // 양보하는 코드
    // runBlocking이 갖고 있는 block에서 실행이 중단되고 위의 launch로 주도권이 넘어간다.
    yield()
    printWithTread("END")
}