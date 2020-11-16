package com.maxsch.rxjavalecture.callback

import com.maxsch.rxjavalecture.entities.Animal
import com.maxsch.rxjavalecture.entities.Cat
import com.maxsch.rxjavalecture.entities.Dog
import com.maxsch.rxjavalecture.entities.Rat
import kotlin.random.Random

interface GetAnimalsListener {
    fun onSuccess(animals: List<Animal>)
    fun onError(error: Throwable)
}

interface CatsApi {
    fun getCats(listener: GetAnimalsListener)
}

interface DogsApi {
    fun getDogs(listener: GetAnimalsListener)
}

interface RatsApi {
    fun getRats(listener: GetAnimalsListener)
}

class CatsApiImpl : CatsApi {

    override fun getCats(listener: GetAnimalsListener) {
        if (Random.nextBoolean()) {
            listener.onSuccess(
                listOf(
                    Cat(
                        "John",
                        "10"
                    )
                )
            )
        } else {
            listener.onError(Throwable("No cats available"))
        }
    }
}

class DogsApiImpl : DogsApi {

    override fun getDogs(listener: GetAnimalsListener) {
        if (Random.nextBoolean()) {
            listener.onSuccess(
                listOf(
                    Dog(
                        "Michel",
                        "4"
                    )
                )
            )
        } else {
            listener.onError(Throwable("No dogs available"))
        }
    }
}

class RatsApiImpl : RatsApi {

    override fun getRats(listener: GetAnimalsListener) {
        if (Random.nextBoolean()) {
            listener.onSuccess(
                listOf(
                    Rat(
                        "Christie",
                        "1"
                    )
                )
            )
        } else {
            listener.onError(Throwable("No rats available"))
        }
    }
}