package com.greemoid.realizationcoremvvm.currencies.data

import com.github.johnnysc.coremvvm.data.CloudDataSource
import com.github.johnnysc.coremvvm.data.HandleError

interface CurrenciesCloudDataSource {

    suspend fun latestCurrencies(): CurrenciesCloud

    class Base(
        private val currencyService: CurrencyService,
        handleError: HandleError
    ) : CloudDataSource.Abstract(handleError), CurrenciesCloudDataSource {

        override suspend fun latestCurrencies() = handle {
            currencyService.currencies()
        }
    }
}