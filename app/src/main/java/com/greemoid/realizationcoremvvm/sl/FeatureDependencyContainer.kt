package com.greemoid.realizationcoremvvm.sl

import androidx.lifecycle.ViewModel
import com.github.johnnysc.coremvvm.data.PreferenceDataStore
import com.github.johnnysc.coremvvm.sl.CoreModule
import com.github.johnnysc.coremvvm.sl.DependencyContainer
import com.github.johnnysc.coremvvm.sl.Module
import com.greemoid.realizationcoremvvm.currencies.data.CurrenciesCache
import com.greemoid.realizationcoremvvm.currencies.data.FavoritesCacheDataSource
import com.greemoid.realizationcoremvvm.currencies.presentation.CurrenciesViewModel
import com.greemoid.realizationcoremvvm.favorites.data.FavoriteCurrencies
import com.greemoid.realizationcoremvvm.favorites.presentation.FavoritesViewModel

class FeatureDependencyContainer(
    private val coreModule: CoreModule,
    private val dependencyContainer: DependencyContainer
) : DependencyContainer {

    private val favoritesCacheDataSource = FavoritesCacheDataSource.Base(
        FavoriteCurrencies.Base(
            PreferenceDataStore.Base(coreModule.sharedPreferences(PREFS_KEY))
        )
    )

    private val cache = CurrenciesCache.Base()

    override fun <T : ViewModel> module(clazz: Class<T>): Module<*> {
        return when(clazz) {
            CurrenciesViewModel::class.java -> CurrenciesModule(
                coreModule,
                favoritesCacheDataSource,
                cache
            )
            FavoritesViewModel::class.java -> FavoritesModule(
                coreModule,
                favoritesCacheDataSource,
                cache
            )
            else -> dependencyContainer.module(clazz)
        }
    }

    companion object {
        private const val PREFS_KEY = "favorites"
    }
}