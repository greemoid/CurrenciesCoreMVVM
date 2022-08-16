package com.greemoid.realizationcoremvvm.currencies.data

import com.greemoid.realizationcoremvvm.currencies.domain.CurrenciesDomain
import com.greemoid.realizationcoremvvm.currencies.domain.CurrencyRepository

class BaseCurrencyRepository(
    private val cacheDataSource: FavoritesCacheDataSource,
    private val cache: CurrenciesCache.Save,
    private val cloudDataSource: CurrenciesCloudDataSource,
    private val mapper: CurrenciesCloud.Mapper<CurrenciesDomain>
) : CurrencyRepository {

    override suspend fun currencies(): CurrenciesDomain {
        val currencies = cloudDataSource.latestCurrencies()
        cache.save(currencies)
        return currencies.map(mapper)
    }

    override fun changeFavorite(id: String) = cacheDataSource.changeFavorite(id)
}