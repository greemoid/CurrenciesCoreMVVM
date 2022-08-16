package com.greemoid.realizationcoremvvm.currencies.domain

import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.data.HandleError
import com.github.johnnysc.coremvvm.domain.Interactor
import com.greemoid.realizationcoremvvm.currencies.presentation.CurrenciesUi

interface CurrenciesInteractor {

    suspend fun currencies(
        atFinish: () -> Unit,
        successful: (CurrenciesUi) -> Unit
    )

    class Base(
        private val mapper: CurrenciesDomain.Mapper<CurrenciesUi>,
        private val repository: CurrencyRepository,
        dispatchers: Dispatchers,
        handleError: HandleError
    ) : Interactor.Abstract(dispatchers, handleError), CurrenciesInteractor {

        override suspend fun currencies(
            atFinish: () -> Unit,
            successful: (CurrenciesUi) -> Unit,
        ) = handle(successful, atFinish) {
            val data = repository.currencies()
            return@handle data.map(mapper)
        }
    }
}