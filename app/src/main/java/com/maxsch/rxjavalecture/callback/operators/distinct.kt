package com.maxsch.rxjavalecture.callback.operators

import com.maxsch.rxjavalecture.callback.entity.cats
import io.reactivex.Observable

/*
* Выведет только уникальных котов (Maison в коллекции встречается дважды, однако благодаря этому
* оператору он выведется один раз)
*/
val distinctedObservable = Observable.fromIterable(cats)
    .distinct()