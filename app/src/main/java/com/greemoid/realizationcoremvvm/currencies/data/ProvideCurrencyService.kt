package com.greemoid.realizationcoremvvm.currencies.data

import com.github.johnnysc.coremvvm.data.MakeService
import com.github.johnnysc.coremvvm.data.ProvideRetrofitBuilder

interface ProvideCurrencyService {

    fun currencyService(): CurrencyService

    class Base(
        retrofitBuilder: ProvideRetrofitBuilder,
    ) : MakeService.Abstract(
        retrofitBuilder
    ), ProvideCurrencyService {

        override fun baseUrl(): String = "http://data.fixer.io/"

        override fun currencyService(): CurrencyService = service(CurrencyService::class.java)
    }
}