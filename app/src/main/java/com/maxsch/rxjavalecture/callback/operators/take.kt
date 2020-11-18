package com.maxsch.rxjavalecture.callback.operators

import com.maxsch.rxjavalecture.callback.entity.cats
import io.reactivex.Observable

// В отличии от skip наоброт, возьмет первые 3 излучения
val takenObservable = Observable.fromIterable(cats)
    .take(3)