package com.maxsch.rxjavalecture.callback.operators

import com.maxsch.rxjavalecture.callback.entity.cats
import com.maxsch.rxjavalecture.callback.entity.dogs
import io.reactivex.Observable

val catsObservable = Observable.fromIterable(cats)
val dogsObservable = Observable.fromIterable(dogs)

//Сначала придут все коты, после чего все псы
val catsAndDogs = Observable.concat(catsObservable, dogsObservable)