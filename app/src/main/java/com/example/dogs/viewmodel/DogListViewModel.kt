package com.example.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogs.model.DogBreedModel

class DogListViewModel : ViewModel() {
    val dogBreedList = MutableLiveData<List<DogBreedModel>>()
    val dogLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun loadData() {
        val dog1 = DogBreedModel("1", "Poodle", "Description", null)
        val dog2 = DogBreedModel("2", "Labrador", "Description", null)
        val dog3 = DogBreedModel("3", "Golden", "Description", null)
        val dog4 = DogBreedModel("4", "Husky", "Description", null)

        dogBreedList.value = arrayListOf<DogBreedModel>(dog1, dog2, dog3, dog4)
        dogLoadError.value = false
        loading.value = false
    }
}