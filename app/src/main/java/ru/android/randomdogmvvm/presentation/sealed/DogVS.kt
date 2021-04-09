package ru.android.randomdogmvvm.presentation.sealed

import ru.android.randomdogmvvm.domain.model.DogBody

sealed class DogVS {
    class Post(val postVM: DogBody): DogVS()
    class Error(val message: String?): DogVS()
    class ShowLoader(val showLoader: Boolean): DogVS()
}
