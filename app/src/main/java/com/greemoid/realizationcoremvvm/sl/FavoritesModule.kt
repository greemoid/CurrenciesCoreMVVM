package com.greemoid.realizationcoremvvm.sl

import com.github.johnnysc.coremvvm.sl.CoreModule
import com.github.johnnysc.coremvvm.sl.Module
import com.greemoid.realizationcoremvvm.currencies.data.CurrenciesCache
import com.greemoid.realizationcoremvvm.currencies.data.FavoritesCacheDataSource
import com.greemoid.realizationcoremvvm.currencies.presentation.ChangeFavorite
import com.greemoid.realizationcoremvvm.favorites.data.FavoriteMapper
import com.greemoid.realizationcoremvvm.favorites.data.FavoritesRepository
import com.greemoid.realizationcoremvvm.favorites.presentation.FavoritesCommunication
import com.greemoid.realizationcoremvvm.favorites.presentation.FavoritesViewModel
import com.greemoid.realizationcoremvvm.favorites.presentation.UpdateFavorites

class FavoritesModule(
    private val coreModule: CoreModule,
    private val cacheDataSource: FavoritesCacheDataSource,
    private val cache: CurrenciesCache.Read,
) : Module<FavoritesViewModel> {
    override fun viewModel(): FavoritesViewModel {
        val communication = FavoritesCommunication.Base()
        val update = UpdateFavorites.Base()
        return FavoritesViewModel(
            update,
            FavoritesRepository.Base(
                cache,
                FavoriteMapper.Base(
                    cacheDataSource,
                    ChangeFavorite.Combo(cacheDataSource, update)
                )
            ),
            communication,
            coreModule.dispatchers()
        )
    }
}