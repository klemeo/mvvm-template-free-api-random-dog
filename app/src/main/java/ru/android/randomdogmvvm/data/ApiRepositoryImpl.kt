package ru.android.randomdogmvvm.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.android.randomdogmvvm.data.mapper.DogDataMapper
import ru.android.randomdogmvvm.data.model.DogResponsesBody
import ru.android.randomdogmvvm.domain.ApiRepository

class ApiRepositoryImpl(
    private val apiResponseDataSource: PostResponseDataSource
) : ApiRepository {

    private val dogDataMapper by lazy { DogDataMapper() }

    override fun getDog(): Flow<DogResponsesBody> =
        apiResponseDataSource.getDog().map {
            dogDataMapper.map(it)
        }

}