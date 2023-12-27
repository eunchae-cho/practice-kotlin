package com.example.demo.generic

abstract class Animal(
    val name: String
)

abstract class Fish(name: String): Animal(name)

class GoldFish(name: String): Fish(name)

class Carp(name: String): Fish(name)

fun main() {
    // 객체 타입이 안 맞는 경우 컴파일 에러가 아닌 런타임 에러로 발생
//    val cage = Cage()
//    cage.put(GoldFish("금붕어"))
//    val carp: Carp = cage.getFirst() as Carp

    // 방법 1. Safe Type Casting
    // 형변환 실패 시 null이 발생 -> Exception이 발생
    val cage = Cage()
    cage.put(Carp("잉어"))
    val carp: Carp = cage.getFirst() as? Carp ?: throw IllegalArgumentException()

    // 아이디어 -> 금붕어만 들어가는 cage와 잉어만 들어가는 cage가 있었음 좋겠다..!
    // 바로 제네릭을 이용하면 된다!
    val cage2 = Cage2<Carp>()
    cage.put(Carp("잉어"))
    val carp2: Carp = cage2.getFirst()

    // 상속 관계의 의미
    // 상위 타입이 들어가는 자리에 하위 타입이 대신 위치할 수 있다.
    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))
    val cage3 = Cage2<Fish>()
    cage3.moveFrom(goldFishCage)
}