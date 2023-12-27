package com.example.demo.generic
// declaration-site variance
// 소비만 하는 클래스
// 반공변하도록 만듦
class Cage4<in T> {
    private val animals: MutableList<T> = mutableListOf()

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun putAll(animals: List<T>) {
        this.animals.addAll(animals)
    }
}


// 이렇게 코틀린에서 클래스를 선호하는 지접에 변성을 주는 것을
// declaration-site variance 라고 한다.


// use-site variance(변수나 함수에 선언)와 같은 방식은 자바에서도 존재하지만
// declaration-site variance(클래스에 선언)은 자바에 존재하지 않는다.

// in 예시 -> Comparable 클래스
// out 예시 -> List 인터페이스
// List의 contains() -> @UnsafeVariance를 통해 생산만 하는 클래스에서 타입 안정성을 유지하며 생산 또는 소비할 수 있다.