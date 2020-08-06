package com.example.dogs.model

import io.reactivex.Single
import retrofit2.http.GET

interface DogApi {

    @GET(value = "DevTides/DogsApi/master/dogs.json")
    fun getDogs(): Single<List<DogBreedModel>>
}