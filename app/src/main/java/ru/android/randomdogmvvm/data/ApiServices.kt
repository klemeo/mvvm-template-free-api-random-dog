package ru.android.randomdogmvvm.data

import retrofit2.http.*
import ru.android.randomdogmvvm.data.model.dto.DogResponsesBodyData

interface ApiServices {

    @GET("breeds/image/random")
    suspend fun getDog(): DogResponsesBodyData

}