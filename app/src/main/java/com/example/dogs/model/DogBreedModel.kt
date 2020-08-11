package com.example.dogs.model

import com.google.gson.annotations.SerializedName

data class DogBreedModel(
    val uuid: String?,

    @SerializedName("name")
    val dogBreedName: String?,

    @SerializedName("origin")
    val dogBreedDescription: String?,

    @SerializedName("temperament")
    val dogTemperament: String?,

    @SerializedName("url")
    val dogImage: String?
)