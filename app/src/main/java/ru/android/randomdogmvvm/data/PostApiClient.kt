package ru.android.randomdogmvvm.data

import ru.android.randomdogmvvm.base.network.BaseApiClient

object PostApiClient : BaseApiClient<ApiServices>(ApiServices::class.java)