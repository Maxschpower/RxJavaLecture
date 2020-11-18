package com.maxsch.rxjavalecture.callback.multithread

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

val bearObservable = Flowable.fromIterable(bear.split("\n")).parallel()

val parallelObservable =
    bearObservable
        .runOn(Schedulers.computation())
        .doOnNext {
            println("${Thread.currentThread()}")
            println(it)
        }
        .runOn(Schedulers.newThread())
        .doOnNext {
            println("${Thread.currentThread()}")
            println(it)
        }
        .sequential()