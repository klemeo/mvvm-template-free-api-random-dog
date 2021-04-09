package ru.android.randomdogmvvm.app

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.android.randomdogmvvm.data.ApiRepositoryImpl
import ru.android.randomdogmvvm.data.PostResponseDataSource
import ru.android.randomdogmvvm.domain.ApiRepository
import ru.android.randomdogmvvm.domain.interactor.DogInteractor
import ru.android.randomdogmvvm.presentation.home.HomeViewModel

private val postModule = module {

    //region ViewModel

    viewModel {
        HomeViewModel(
            dogInteractor = get()
        )
    }
    //endregion

    //region Interactor
    single {
        DogInteractor(
            apiRepository = get()
        )
    }

    //endregion

    //region Repository
    single<ApiRepository> {
        ApiRepositoryImpl(
            apiResponseDataSource = get()
        )
    }
    //endregion

    //region Datastore
    single {
        PostResponseDataSource()
    }
    //endregion
}

val modules = listOf(postModule)