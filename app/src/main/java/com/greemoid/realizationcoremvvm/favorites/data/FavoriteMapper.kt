package com.greemoid.realizationcoremvvm.favorites.data

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.greemoid.realizationcoremvvm.currencies.data.CurrenciesCloud
import com.greemoid.realizationcoremvvm.currencies.data.IsFavorite
import com.greemoid.realizationcoremvvm.currencies.presentation.ChangeFavorite
import com.greemoid.realizationcoremvvm.currencies.presentation.CurrencyUi

interface FavoriteMapper : CurrenciesCloud.Mapper<List<ItemUi>> {

    class Base(
        private val isFavorite: IsFavorite,
        private val changeFavorite: ChangeFavorite
    ) : FavoriteMapper {
        override fun map(
            base: String,
            date: String,
            currencies: Map<String, Double>,
        ): List<ItemUi> {
            val filteredList = currencies.map { Pair(it.key, it.value) }.toList()
                .filter { isFavorite.isFavorite(it.first) }
            return filteredList.map {
                CurrencyUi(
                    it.first,
                    "$base/${it.first}: ${it.second}",
                    true,
                    changeFavorite
                )
            }
        }

    }
}