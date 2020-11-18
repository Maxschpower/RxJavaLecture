package com.maxsch.rxjavalecture.callback.operators

import com.maxsch.rxjavalecture.callback.entity.Cat
import com.maxsch.rxjavalecture.callback.entity.Dog
import io.reactivex.Single

// На каждый эмит оригинального источника передаст управление источнику, указанному в flatMap
val flatMappedObservable = catsObservable.flatMap { cat ->
    dogsObservable.map { dog ->
        dog.copy(name = dog.name + cat.name)
    }
}

/*
* Пример с использованием Single
* */

val catSingle = Single.just(Cat("Dmitry", 20))

fun getDogSingle(cat: Cat) = Single.just(Dog("${cat.name} dog", cat.age))

fun getCatSingle(dog: Dog) = Single.just(Cat("${dog.name} cat", dog.age))

/*
* При подписке мы получим пса, с данными, которые передавал кот.
* Данное поведение может быть полезно при реализации, например, регистрации.
* Мы регистрируем пользователя, получаем токен, затем токен
* сохраняем, затем с этим токеном логиним его в приложении сразу после регистрации
* */
val flatMappedSingle = catSingle
    .flatMap { getDogSingle(it) }
    .flatMap { getCatSingle(it) }