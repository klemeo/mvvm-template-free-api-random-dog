package ru.android.randomdogmvvm.data.mapper

import ru.android.randomdogmvvm.base.mapper.Mapper
import ru.android.randomdogmvvm.data.model.DogResponsesBody
import ru.android.randomdogmvvm.data.model.dto.DogResponsesBodyData

class DogDataMapper : Mapper<DogResponsesBodyData, DogResponsesBody> {

    override fun map(origin: DogResponsesBodyData) = DogResponsesBody(
        message = origin.message,
        status = origin.status
    )

}