package com.maxsch.rxjavalecture.reactive

import android.os.Looper
import android.util.Log
import com.maxsch.rxjavalecture.entities.Cat
import com.maxsch.rxjavalecture.entities.Dog
import com.maxsch.rxjavalecture.entities.Rat
import io.reactivex.Single
import kotlin.random.Random

interface RxCatsApi {
    fun getCats(): Single<List<Cat>>
}

interface RxDogsApi {
    fun getDogs(): Single<List<Dog>>
}

interface RxRatsApi {
    fun getRats(): Single<List<Rat>>
}

class RXCatsApiImpl : RxCatsApi {

    override fun getCats(): Single<List<Cat>> =
        Single.create {
            Log.e("asd", "${Thread.currentThread()} ${Looper.getMainLooper().thread}")
            if (Random.nextBoolean()) {
                it.onSuccess(
                    listOf(
                        Cat(
                            "John",
                            "10"
                        ),
                        Cat(
                            "Kate",
                            "7"
                        ),
                    )
                )
            } else {
                it.onError(Throwable())
            }
        }
}

class RxDogsApiImpl : RxDogsApi {

    override fun getDogs(): Single<List<Dog>> =
        Single.create {
            if (Random.nextBoolean()) {
                it.onSuccess(
                    listOf(
                        Dog(
                            "Michel",
                            "4"
                        )
                    )
                )
            } else {
                it.onError(Throwable("No dogs available"))
            }
        }
}

class RxRatsApiImpl : RxRatsApi {

    override fun getRats(): Single<List<Rat>> =
        Single.create {
            if (Random.nextBoolean()) {
                it.onSuccess(
                    listOf(
                        Rat(
                            "Christie",
                            "1"
                        )
                    )
                )
            } else {
                it.onError(Throwable("No rats available"))
            }
        }
}