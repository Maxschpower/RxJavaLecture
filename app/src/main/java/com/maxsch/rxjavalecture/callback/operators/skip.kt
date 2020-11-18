package com.maxsch.rxjavalecture.callback.operators

import com.maxsch.rxjavalecture.callback.entity.cats
import io.reactivex.Observable

//Выведет список котов, без трех первых
val skippedObservable = Observable.fromIterable(cats)
    .skip(3)