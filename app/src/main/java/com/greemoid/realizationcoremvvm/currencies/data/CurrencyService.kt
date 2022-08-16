package com.greemoid.realizationcoremvvm.currencies.data

import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {

    @GET("api/latest")
    suspend fun currencies(
        @Query("access_key") accessKey: String = "b1f6bbc65654436995edda916fe31f06"
    ) : CurrenciesCloud.Base
}