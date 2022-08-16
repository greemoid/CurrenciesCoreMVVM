package com.greemoid.realizationcoremvvm.currencies.presentation

import com.greemoid.realizationcoremvvm.favorites.presentation.UpdateFavorites

interface ChangeFavorite {

    fun changeFavorite(id: String)

    class Combo(
        private val changeFavorite: ChangeFavorite,
        private val communication: UpdateFavorites.Update,
    ) : ChangeFavorite {
        override fun changeFavorite(id: String) {
            changeFavorite.changeFavorite(id)
            communication.map(true)
        }

    }
}