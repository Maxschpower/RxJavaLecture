package com.maxsch.rxjavalecture.callback.operators

import java.util.concurrent.TimeUnit

//Источник начнет излучать данные с задержкой в две секунды
val delayedObservable = catsObservable.delay(2, TimeUnit.SECONDS)