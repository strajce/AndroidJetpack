package com.example.dogs.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogs.model.DogBreedModel

class DogDetailsViewModel : ViewModel() {
    val dogBreedDetails = MutableLiveData<DogBreedModel>()

    fun showDogBreedDetails(dog: DogBreedModel) {
        dogBreedDetails.value = dog
    }
}