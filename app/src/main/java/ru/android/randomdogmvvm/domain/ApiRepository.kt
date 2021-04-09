package ru.android.randomdogmvvm.domain

import kotlinx.coroutines.flow.Flow
import ru.android.randomdogmvvm.data.model.DogResponsesBody

interface ApiRepository {

    fun getDog(): Flow<DogResponsesBody>

}