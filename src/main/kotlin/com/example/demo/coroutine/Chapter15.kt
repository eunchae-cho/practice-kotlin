package com.example.demo.coroutine

import kotlinx.coroutines.*

/**
 * CoroutineScope
 * */

class Chapter15 {
}

suspend fun main() {
//    CoroutineScope(Dispatchers.Default).launch {
//        delay(1000)
//        printWithTread("Job 1")
//    }
//
//    Thread.sleep(2000)

    val job = CoroutineScope(Dispatchers.Default).launch {
        delay(1000)
        printWithTread("Job 1")
    }

    job.join()
}