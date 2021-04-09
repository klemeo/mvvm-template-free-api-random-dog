package ru.android.randomdogmvvm.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.android.randomdogmvvm.base.interactor.Interactor
import ru.android.randomdogmvvm.data.model.DogResponsesBody
import ru.android.randomdogmvvm.domain.ApiRepository

class DogInteractor(
    private val apiRepository: ApiRepository
) : Interactor<Interactor.None, Flow<DogResponsesBody>> {

    override fun execute(params: Interactor.None): Flow<DogResponsesBody> {
        return apiRepository.getDog()
    }

}