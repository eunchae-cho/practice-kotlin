package com.example.demo.coroutine
/**
 * 루틴과 코루틴의 차이
 * - 루틴에 진입하는 곳은 한 군데이며, 종료되면 해당 루팅의 정보가 초기화된다.
 * */
class Chapter1 {
    // 직관적인 코드 함수
    fun newRoutine() {
        // 새로운 루틴이 호출되면, 스택에 지역변수가 초기화되고
        // 루틴이 끝나면 해당 메모리에 접근이 불가능하다.
        // 그리고 언젠가 garbage collector에 의해 메모리에서 살아지게 된다.
        val num1 = 1
        val num2 = 2
        println("${num1 + num2}")
    }
}

fun main() {
    println("START")
    // 이 루틴을 종료하는 순간 다시 메인 함수로 코드 실행이 넘어오는 순간
    // 더 이상 num1과 num2는 존재하지 않는다.
    Chapter1().newRoutine()
    println("END")
}
// 실행결과
// START
// 3
// END