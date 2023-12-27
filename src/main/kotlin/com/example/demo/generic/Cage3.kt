package com.example.demo.generic
// declaration-site variance
// 생산만 하는 클래스
// 클래스 자체를 공변하게 만듦
// 소비를 위한 'T'를 받을 수 없다.
// 왜냐하면 타입 안전성이 깨지기 때문
class Cage3<out T> {
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T {
        return this.animals.first()
    }

    fun getAll(): List<T> {
        return this.animals
    }
}

fun main() {
    val fishCage = Cage3<Fish>()
    val animalCage : Cage3<Animal> = fishCage
}