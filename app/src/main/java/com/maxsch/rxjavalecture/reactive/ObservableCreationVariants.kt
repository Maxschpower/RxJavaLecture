package com.maxsch.rxjavalecture.reactive

import com.maxsch.rxjavalecture.entities.Cat
import io.reactivex.Observable

val justObservable = Observable.just(
    Cat(
        "John",
        "10"
    )
)

val rangeObservable = Observable.range(0, 100)

val createObservable = Observable.create<Int> {
    it.onNext(123)
    it.onNext(321)
    it.onComplete()
}

val catsArray = arrayOf(
    Cat(
        "John",
        "10"
    ), Cat(
        "Kate",
        "6"
    ), Cat(
        "Gleb",
        "61"
    ), Cat(
        "Kate",
        "16"
    ), Cat(
        "Kate",
        "26"
    )
)

val observableFromArray = Observable.fromArray(*catsArray)

val observableFromCallable = Observable.fromCallable {
    getCat()
}

fun getCat() = Cat("John", "10")