package com.maxsch.rxjavalecture.callback.operators

import io.reactivex.Observable

/*
* Работает почти так же как и concat, за исключением обработки терминальных событий и того факта
* что данные при merge будут идти не последовательно, а перемешаны. Если во время излучения
* данных в concat один из observable вернет ошибку или complete - продолжится эмиттинг вторым observable.
* Однако при использовании merge, когда любой из источников выбросит ошибку или complete - оба будут
* disposed.
* Причем может возникнуть ситуация, когда оба observable примерно в одно время выбрасывают
* ошибку - тогда вас не спасет вторая лямбда в subscribe, тк ошибка будет обработана глобальным
* обработчиком ошибок
* */
val mergedObservable = Observable.merge(catsObservable, dogsObservable)