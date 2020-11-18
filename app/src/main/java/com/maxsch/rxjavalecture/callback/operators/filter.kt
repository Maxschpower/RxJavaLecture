package com.maxsch.rxjavalecture.callback.operators

import com.maxsch.rxjavalecture.callback.entity.cats
import io.reactivex.Observable

//Придут только те коты, чей возраст старше 4
val filteredObservable = Observable.fromIterable(cats)
    .filter {
        it.age > 4
    }