package com.maxsch.rxjavalecture.callback.operators

import com.maxsch.rxjavalecture.callback.entity.Cat
import io.reactivex.Observable

val observable = Observable
    .fromArray(
        Cat("firstCat", 1),
        Cat("secondCat", 2)
    )
    .doOnSubscribe {
        println("subscribed!")
    }
    .doOnEach {
        println("got event $it")
    }
    .doOnNext {
        println("got emit: $it")
    }
    .doAfterNext {
        println("after next event")
    }
    .doOnComplete {
        println("completed!")
    }
    .doOnTerminate {
        println("terminated!")
    }
    .doAfterTerminate {
        println("after terminate")
    }
    .subscribe()