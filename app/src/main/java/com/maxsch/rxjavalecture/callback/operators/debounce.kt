package com.maxsch.rxjavalecture.callback.operators

import java.util.concurrent.TimeUnit

/*
* Сложный но очень полезный оператор. Особенность состоит в том, что он позволяет отсеивать слишком
* частые излучения. Например события ввода текса - если мы повесим на текстовое поле слушатель, и
* при каждом эмите заставим его искать информацию - приложение начнет лагать, из-за большого количества
* запросов.
* debounce перед отправкой эмита заставляет подождать некоторое количество времени, чтобы убедиться,
* что в ближайшее время эмитов не ожидается. Если в указанное время не приходит ни одного эмита -
* отправляется последний элемент. Если во время ожидания появился новый элемент - заново запускается
* ожидание
* */

/*
* В данном случае придет только последний элемент, тк оператор fromIterable отдает все элементы
* максимально быстро (явно быстрее чем раз в секунду)
* */
val debouncedObservable = catsObservable.debounce(1L, TimeUnit.SECONDS)