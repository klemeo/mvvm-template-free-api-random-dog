package ru.android.randomdogmvvm.presentation.mapper

import ru.android.randomdogmvvm.base.mapper.Mapper
import ru.android.randomdogmvvm.data.model.DogResponsesBody
import ru.android.randomdogmvvm.domain.model.DogBody

class DogMapper : Mapper<DogResponsesBody, DogBody> {

    override fun map(origin: DogResponsesBody) = DogBody(
        message = origin.message,
        status = origin.status
    )

}