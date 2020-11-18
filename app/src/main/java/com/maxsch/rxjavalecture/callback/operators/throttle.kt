package com.maxsch.rxjavalecture.callback.operators

import java.util.concurrent.TimeUnit

/*
* Оператор похож на debounce, только отличие в том что таймер ожидания не перезапускается прикаждом
* новом излучении.
* При использовании этого оператора таймер начнется после эмита первого элемента, затем каждые n
* единиц времени, если в указанный промежуток случилось несколько эмитов - возьмется ближайший к
* концу этого окна.
* При указании emitLatest true - последнее излучение перед complete отправится вне зависимости от
* окна
* */
val throttledObservable = catsObservable.throttleFirst(10L, TimeUnit.MILLISECONDS)