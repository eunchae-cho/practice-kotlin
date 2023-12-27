package com.example.demo.generic

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

    // 무공변
    // 왜 Fish와 GoldFish 간의 상속관계가 제네릭 클래스에서 유지되지 않을까
    // 타입 파라미터 상속 관계는 무공변하다.
    // 자바에서 일반 배열은 상속 관계에 있어서 공변하다. 반면, 리스트는 타입 파라미터로 존재하기 때문에 무공변하다.
    // 따라서, 이펙티브 자바에서 배열보다 리스트를 사용하라는 의미는 제네릭 타입의 리스트가 타입의 불일치성을 잡아주기 때문이다. => 타입 안전한 코드


    // 공변
    // use-site variance
    // 변성을 주다. = 어떠한 관계를 만들어 주다.
    // 'out'을 붙어주면서 공변하게 되었다.
    // out annotation
    // out을 붙이면 함수 파라미터의 생산자 역할만 한다.
    // 타입 파라미터의 상속 관계가 제네릭 클래스에서 유지
    // Java(와일드카드 타입) -> <? extends T>
    fun moveFrom(otherCage: Cage2<out T>) {
        this.animals.addAll(otherCage.animals)
    }

    // 반공변
    // use-site variance
    // 타입 파라미터 상태의 상속 관계는 유지
    // in을 붙이면 함수 파라미터의 소비자 역할만 한다.
    // 타입 파라미터의 상속 관계가 제네릭 클래스에서 반대로 된다.
    // Java(와일드카드 타입) -> <? super T>
    fun moveTo(otherCage: Cage2<in T>) {
        otherCage.animals.addAll(this.animals)
    }

    // 함수나 변수 지점에 변성을 주는 것을
    // use-site variance 라고 한다.
}