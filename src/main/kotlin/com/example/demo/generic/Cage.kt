package com.example.demo.generic

class Cage {
    private val animals: MutableList<Animal> = mutableListOf()

    fun getFirst(): Animal {
        return animals.first()
    }

    fun put(animal: Animal) {
        this.animals.add(animal)
    }

    fun moveFrom(cage: Cage) {
        this.animals.addAll(cage.animals)
    }
}

// T : 타입파리이터
class Cage2<T> {
    // MutableList도 제네릭 타입이기 때문에 제네릭을 지정해줘야 한다.
    private val animals: MutableList<T> = mutableListOf()

    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        this.animals.add(animal)
    }

    // 변성을 주다. = 어떠한 관계를 만들어 주다.
    // 'out'을 붙어주면서 공변하게 되었다.
    // out annotation
    // out을 붙이면 함수 파라미터의 생산자 역할만 한다.
    // 타입 파라미터의 상속 관계가 제네릭 클래스에서 유지
    fun moveFrom(otherCage: Cage2<out T>) {
        this.animals.addAll(otherCage.animals)
    }

    // 반공변
    // 타입 파라미터 상태의 상속 관계는 유지
    // in을 붙이면 함수 파라미터의 소비자 역할만 한다.
    // 타입 파라미터의 상속 관계가 제네릭 클래스에서 반대로 된다.
    fun moveTo(otherCage: Cage2<in T>) {
        otherCage.animals.addAll(this.animals)
    }
}