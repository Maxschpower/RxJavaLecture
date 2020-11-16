package com.maxsch.rxjavalecture.callback

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.maxsch.rxjavalecture.R
import com.maxsch.rxjavalecture.entities.Animal
import com.maxsch.rxjavalecture.reactive.*
import com.maxsch.rxjavalecture.reactive.observableFromArray

class MainActivity : AppCompatActivity() {

    private var catsReady = false
    private var dogsReady = false
    private var ratsReady = false

    private val tmpAnimalCollector = mutableListOf<Animal>()

    private val catsApi = CatsApiImpl()
    private val dogsApi = DogsApiImpl()
    private val ratsApi = RatsApiImpl()

    private val getCatsListener: GetAnimalsListener = object :
        GetAnimalsListener {
        override fun onSuccess(animals: List<Animal>) {
            tmpAnimalCollector.addAll(animals)
            catsReady = true
            onAnimalsReady()
        }

        override fun onError(error: Throwable) {
            onAnimalsFail()
        }
    }

    private val getDogsListener: GetAnimalsListener = object :
        GetAnimalsListener {
        override fun onSuccess(animals: List<Animal>) {
            tmpAnimalCollector.addAll(animals)
            dogsReady = true
            onAnimalsReady()
        }

        override fun onError(error: Throwable) {
            onAnimalsFail()
        }
    }

    private val getRatsListener: GetAnimalsListener = object :
        GetAnimalsListener {
        override fun onSuccess(animals: List<Animal>) {
            tmpAnimalCollector.addAll(animals)
            ratsReady = true
            onAnimalsReady()
        }

        override fun onError(error: Throwable) {
            onAnimalsFail()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observableFromArray.subscribe {
            Log.e("event", "$it")
        }
    }

    private fun getData() {
        catsApi.getCats(getCatsListener)
        ratsApi.getRats(getRatsListener)
        dogsApi.getDogs(getDogsListener)
    }

    private fun onAnimalsFail() {
        getData()
    }

    private fun onAnimalsReady() {
        if (ratsReady && catsReady && dogsReady) {
            loadPrices(tmpAnimalCollector)
        }
    }

    private fun loadPrices(tmpAnimalCollector: MutableList<Animal>) {
        Log.d("prices", "loaded $tmpAnimalCollector")
    }
}