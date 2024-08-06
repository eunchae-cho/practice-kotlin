package com.example.demo.coroutine

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 * 스레드와 코루틴 차이
 *
 * [프로세스 - 스레드]
 * 프로세스: 컴퓨터에서 실행되고 있는 프로그램
 * 스레드: 프로세스를 실행하는 단위
 * -> 프로세스가 있어야만 스레드가 있을 수 있다.
 * -> 스레드가 프로세스를 바꿀 수 없다.
 *
 * [스레드 - 코루틴]
 * -> 코루틴 코드가 실행되려면, 스레드가 있어야 한다.
 * -> 코루틴이 직접 코드를 실행시키는 것이 아니라 코루틴이 가지고 있는 코드를 직접 스레드에 넘겨서 실행한다.
 * -> 코루틴은 중단되었다가 재개될 수 있다. 이 경우, 다른 스레드를 배정받을 수 있다.
 *
 * [프로세스 Context Switching]
 * CPU Core에서 첫번째 프로세스 메모리를 쓰고 있다가 스위칭이 일어나면 두번째 프로세스 메모리로 완전히 갈아끼워야 한다.
 * -> 모든 메모리가 교체되므로 비용이 많이 발생한다.
 *
 * [스레드 Context Switching]
 * 스레드끼리는 같은 프로세스에 소속되어 있기 때문에 같은 Heap Area 공유할 수 있고 각 스레드마다 독립적인 Stack Area를 가지고 있다.
 * -> Heap 메모리를 공유하고, Stack만 교체되므로 Process보다는 비용이 적다.
 *
 * [코루틴 Context Switching]
 * 한 스레드에서 여러 코루틴을 돌릴 수 있다.
 * 동일 스레드에서 서로 다른 코루틴이 실행되는 경우 동일한 메모리(Heap Area, Stack Area)를 사용한다.
 * -> 동일 스레드에서 코루틴이 실행되면, 메모리 전체를 공유하므로 스레드보다 context switching cost가 낮다.
 * */
class Chapter3 {
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
fun main() = runBlocking {
    printWithTread("START")
    // launch - 반환값이 없는 코루틴을 만든다.
    // 만들어진 코드를 바로 실행하지 않고 넘어간다.
    launch {
        Chapter2().newRoutine()
    }
    printWithTread("main yield()")
    // 양보하는 코드
    // runBlocking이 갖고 있는 block에서 실행이 중단되고 위의 launch로 주도권이 넘어간다.
    yield()
    printWithTread("END")
}
// 실행결과
// START
// END
// 3