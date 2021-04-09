package ru.android.randomdogmvvm.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.android.randomdogmvvm.data.model.dto.DogResponsesBodyData

class PostResponseDataSource {

    fun getDog(): Flow<DogResponsesBodyData> = flow {
        emit(
            PostApiClient.getApiClient().getDog()
        )
    }

}