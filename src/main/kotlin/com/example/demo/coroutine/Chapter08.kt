package com.example.demo.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * 코루틴과 빌더
 * async
 * -> callback을 이용하지 않고 동기 방식으로 코드를 작성할 수 있다. (콜백 지옥 x)
 * -> 주의 사항: CoroutineStart.LAZY 옵션을 사용하면, await() 함수를 호출했을 때 계산 결과를 계속 기다린다.(이를 방지하기 위해, start()를 같이 사용)
 * */
class Chapter08 {
}

// runBlocking -> 코루틴 빌더
fun main() = runBlocking {
    val time = measureTimeMillis {
        val job1 = async(start = CoroutineStart.LAZY) { apiCall1() }
        val job2 = async(start = CoroutineStart.LAZY) { apiCall1() }
        // start()로 대기 상태로 되어 있음
        job1.start()
        job2.start()
        printWithTread(job1.await() + job2.await())
    }
    // 실행 시간 측정
    printWithTread(time)
}

// 1) CoroutineStart.LAZY 인 경우
// -> 2초가 걸린다.
// -> 코루틴이 마칠 때까지 기다린다.
// 2) CoroutineStart.LAZY, job.start() 인 경우
// -> 1초가 걸린다.
// -> start()가 실행함을 의미