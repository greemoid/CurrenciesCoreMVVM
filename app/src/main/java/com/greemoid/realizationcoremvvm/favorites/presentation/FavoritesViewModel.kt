package com.greemoid.realizationcoremvvm.favorites.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.presentation.BaseViewModel
import com.greemoid.realizationcoremvvm.currencies.presentation.CurrenciesUi
import com.greemoid.realizationcoremvvm.favorites.data.FavoritesRepository

class FavoritesViewModel(
    private val updateFavorites: UpdateFavorites.Observe,
    private val repository: FavoritesRepository,
    communication: FavoritesCommunication,
    dispatchers: Dispatchers,
) : BaseViewModel<CurrenciesUi>(communication, dispatchers) {

    init {
        update()
    }

    fun update() = communication.map(repository.favoritesList())

    fun observeUpdate(owner: LifecycleOwner, observer: Observer<Boolean>) =
        updateFavorites.observe(owner, observer)
}