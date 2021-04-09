package ru.android.randomdogmvvm.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.android.randomdogmvvm.base.interactor.Interactor
import ru.android.randomdogmvvm.base.platform.BaseViewModel
import ru.android.randomdogmvvm.base.utils.io
import ru.android.randomdogmvvm.base.utils.ui
import ru.android.randomdogmvvm.domain.interactor.DogInteractor
import ru.android.randomdogmvvm.presentation.mapper.DogMapper
import ru.android.randomdogmvvm.presentation.sealed.DogVS

class HomeViewModel(
    private val dogInteractor: DogInteractor
) : BaseViewModel() {

    val viewState: LiveData<DogVS> get() = mViewState
    private val mViewState = MutableLiveData<DogVS>()

    private val mDogMapper by lazy { DogMapper() }

    fun getDog() {
        viewModelScope.launch {
            mViewState.value = DogVS.ShowLoader(true)
            try {
                io {
                    dogInteractor.execute(
                        Interactor.None
                    )
                        .collect {
                            ui {
                                mViewState.value = DogVS.Post(mDogMapper.map(it))
                            }
                        }
                }
            } catch (e: Exception) {
                ui {
                    mViewState.value = DogVS.Error(e.message)
                }
            }
            mViewState.value = DogVS.ShowLoader(false)
        }
    }

}