package com.maxsch.rxjavalecture.callback.operators

import com.maxsch.rxjavalecture.callback.entity.Cat
import com.maxsch.rxjavalecture.callback.entity.Dog
import io.reactivex.Observable

data class ScreenInfo(val a: Cat, val b: Dog, val c: Cat, val d: Dog)

//Работает так же как и merge, только с возможностью преобразовывания элементов перед их эмиттингом
val zippedObservable =
    Observable.zip(
        catsObservable,
        dogsObservable,
        catsObservable,
        dogsObservable,
        { a, b, c, d -> ScreenInfo(a, b, c, d) }
    )