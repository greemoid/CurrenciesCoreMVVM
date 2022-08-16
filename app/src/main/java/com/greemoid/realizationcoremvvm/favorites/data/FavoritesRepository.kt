package com.greemoid.realizationcoremvvm.favorites.data

import com.greemoid.realizationcoremvvm.currencies.data.CurrenciesCache
import com.greemoid.realizationcoremvvm.currencies.presentation.CurrenciesUi

interface FavoritesRepository {

    fun favoritesList(): CurrenciesUi

    class Base(
        private val cache: CurrenciesCache.Read,
        private val mapper: FavoriteMapper
    ) : FavoritesRepository {

        override fun favoritesList(): CurrenciesUi {
            val list = cache.read().map(mapper)
            return CurrenciesUi.Base(list)
        }

    }
}