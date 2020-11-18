package com.maxsch.rxjavalecture.callback.operators

import com.maxsch.rxjavalecture.callback.entity.cats
import io.reactivex.Observable

//Выведет имя каждого кота с его возрастом
/*
* Jonh7,
* Mary2,
* Katie9,
* Michel17,
* etc
* */
val mappedObservable = Observable.fromIterable(cats)
    .map {
        it.copy(name = "${it.name}${it.age}")
    }