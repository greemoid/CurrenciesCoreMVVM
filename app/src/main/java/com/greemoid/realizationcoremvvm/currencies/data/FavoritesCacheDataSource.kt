package com.greemoid.realizationcoremvvm.currencies.data

import com.greemoid.realizationcoremvvm.currencies.presentation.ChangeFavorite
import com.greemoid.realizationcoremvvm.favorites.data.FavoriteCurrencies

interface FavoritesCacheDataSource : ChangeFavorite, IsFavorite {

    class Base(private val favorites: FavoriteCurrencies.Mutable) : FavoritesCacheDataSource {

        private var cached = favorites.read()

        override fun changeFavorite(id: String) {
            val data = cached.toMutableSet()
            if (isFavorite(id))
                data.remove(id)
            else
                data.add(id)
            favorites.save(data)
            cached = favorites.read()
        }

        override fun isFavorite(id: String) = cached.contains(id)
    }
}