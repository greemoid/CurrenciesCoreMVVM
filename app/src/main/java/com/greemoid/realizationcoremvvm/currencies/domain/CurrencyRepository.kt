package com.greemoid.realizationcoremvvm.currencies.domain

import com.greemoid.realizationcoremvvm.currencies.presentation.ChangeFavorite

interface CurrencyRepository : ChangeFavorite {
    suspend fun currencies(): CurrenciesDomain
}