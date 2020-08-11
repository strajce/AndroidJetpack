package com.example.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogs.model.DogApiService
import com.example.dogs.model.DogBreedModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DogListViewModel : ViewModel() {
    private val dogService = DogApiService()
    private val disposable = CompositeDisposable()

    val dogBreedList = MutableLiveData<List<DogBreedModel>>()
    val dogLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

//    fun loadData() {
//        val dog1 = DogBreedModel("1", "Poodle", "Description", "")
//        val dog2 = DogBreedModel("2", "Labrador", "Description", "")
//        val dog3 = DogBreedModel("3", "Golden", "Description", "")
//        val dog4 = DogBreedModel("4", "Husky", "Description", "")
//
//        dogBreedList.value = arrayListOf<DogBreedModel>(dog1, dog2, dog3, dog4)
//        dogLoadError.value = false
//        loading.value = false
//    }

    fun loadData() {
        fetchDataRemote()
    }

    private fun fetchDataRemote() {
        loading.value = true

        disposable.add(
            dogService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<DogBreedModel>>() {
                    override fun onSuccess(dogList: List<DogBreedModel>) {
                        dogBreedList.value = dogList
                        dogLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        dogLoadError.value = false
                        loading.value = false
                        e.printStackTrace()
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}