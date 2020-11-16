package com.maxsch.rxjavalecture.reactive

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.maxsch.rxjavalecture.R
import com.maxsch.rxjavalecture.entities.Cat
import com.maxsch.rxjavalecture.entities.Dog
import com.maxsch.rxjavalecture.entities.Rat
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class RxWayActivity : AppCompatActivity() {

    private val catsApi = RXCatsApiImpl()
    private val dogsApi = RxDogsApiImpl()
    private val ratsApi = RxRatsApiImpl()
    private var disposable: Disposable? = null
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        compositeDisposable.add(
            catsApi.getCats()
                .subscribeOn(Schedulers.io())
                .flatMap { cats ->
                    dogsApi.getDogs(cats)
                        .map { dogs ->
                            Pair(cats, dogs)
                        }
                }
                .flatMap { (cats, dogs) ->
                    ratsApi.getRats(dogs)
                        .map { rats ->
                            Triple(cats, dogs, rats)
                        }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ (cats, dogs, rats) ->
                    textView.text = it.toString()
                }, {
                    textView.text = it.toString()
                })
        )
    }

    private fun loadPrices(animals: Triple<List<Cat>, List<Dog>, List<Rat>>): Single<Int> =
        Single.just(1)

    private fun handleAnimalPrices(price: Int) {
        Log.d("prices loaded", "price $price")
    }

    private fun handleLoadingError(error: Throwable) {
        Log.e("error occured", error.message.orEmpty())
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        disposable?.dispose()
        disposable = null
        super.onDestroy()
    }
}