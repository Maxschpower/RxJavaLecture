package com.maxsch.rxjavalecture.reactive

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject

val firstObserver: Observer<Int> = object : Observer<Int> {
    override fun onComplete() {
        Log.e("first", "completed")
    }

    override fun onSubscribe(d: Disposable) {
        Log.e("first", "subscribed")
    }

    override fun onNext(t: Int) {
        Log.e("first", "next item: $t")
    }

    override fun onError(e: Throwable) {
        Log.e("first", e.message.orEmpty())
    }
}

val secondObserver: Observer<Int> = object : Observer<Int> {
    override fun onComplete() {
        Log.e("second", "completed")
    }

    override fun onSubscribe(d: Disposable) {
        Log.e("second", "subscribed")
    }

    override fun onNext(t: Int) {
        Log.e("second", "next item: $t")
    }

    override fun onError(e: Throwable) {
        Log.e("second", e.message.orEmpty())
    }
}

fun publishSubject() {
    val publishSubject = PublishSubject.create<Int>()

    //получит 1,2,3,4 и complete
    publishSubject.subscribe(firstObserver)

    publishSubject.onNext(1)
    publishSubject.onNext(2)
    publishSubject.onNext(3)

    //получит 4 и complete
    publishSubject.subscribe(secondObserver)

    publishSubject.onNext(4)
    publishSubject.onComplete()
}

fun replaySubject() {
    val replaySubject = ReplaySubject.create<Int>()

    //получит 1,2,3,4 и onComplete
    replaySubject.subscribe(firstObserver)

    replaySubject.onNext(1)
    replaySubject.onNext(2)
    replaySubject.onNext(3)
    replaySubject.onNext(4)
    replaySubject.onComplete()

    //получит 1,2,3,4 и onComplete
    replaySubject.subscribe(secondObserver)
}

fun replaySubjectLimited() {
    val replaySubject = ReplaySubject.createWithSize<Int>(2)

    //получит 1,2,3,4 и onComplete
    replaySubject.subscribe(firstObserver)

    replaySubject.onNext(1)
    replaySubject.onNext(2)
    replaySubject.onNext(3)
    replaySubject.onNext(4)
    replaySubject.onComplete()

    //получит 3,4 и onComplete
    replaySubject.subscribe(secondObserver)
}

fun asyncSubject() {
    val asyncSubject = AsyncSubject.create<Int>()

    //получит 4 и complete
    asyncSubject.subscribe(firstObserver)

    asyncSubject.onNext(1)
    asyncSubject.onNext(2)
    asyncSubject.onNext(3)

    //так же получит 4 и complete
    asyncSubject.subscribe(secondObserver)

    asyncSubject.onNext(4)
    asyncSubject.onComplete()
}

fun behaviorSubject() {
    val behaviorSubject = BehaviorSubject.create<Int>()

    //получит 1,2,3,4 и complete
    behaviorSubject.subscribe(firstObserver)

    behaviorSubject.onNext(1)
    behaviorSubject.onNext(2)
    behaviorSubject.onNext(3)

    //получит 3 и все последующие излучения
    behaviorSubject.subscribe(secondObserver)

    behaviorSubject.onNext(4)
    behaviorSubject.onComplete()
}