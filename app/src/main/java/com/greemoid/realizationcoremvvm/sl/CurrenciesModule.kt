package com.greemoid.realizationcoremvvm.sl

import com.github.johnnysc.coremvvm.domain.HandleDomainError
import com.github.johnnysc.coremvvm.presentation.HandleUiError
import com.github.johnnysc.coremvvm.sl.CoreModule
import com.github.johnnysc.coremvvm.sl.Module
import com.greemoid.realizationcoremvvm.currencies.data.*
import com.greemoid.realizationcoremvvm.currencies.domain.CurrenciesDomain
import com.greemoid.realizationcoremvvm.currencies.domain.CurrenciesInteractor
import com.greemoid.realizationcoremvvm.currencies.presentation.CurrenciesCommunication
import com.greemoid.realizationcoremvvm.currencies.presentation.CurrenciesViewModel

class CurrenciesModule(
    private val coreModule: CoreModule,
    private val favorites: FavoritesCacheDataSource,
    private val cache: CurrenciesCache.Save,
) : Module<CurrenciesViewModel> {
    override fun viewModel(): CurrenciesViewModel {
        val repository = BaseCurrencyRepository(
            favorites,
            cache,
            CurrenciesCloudDataSource.Base(
                ProvideCurrencyService.Base(coreModule).currencyService(),
                HandleDomainError()
            ),
            CurrenciesCloud.Mapper.Base()
        )
        return CurrenciesViewModel(
            coreModule.provideCanGoBack(),
            CurrenciesInteractor.Base(
                CurrenciesDomain.Mapper.Base(favorites, repository),
                repository,
                coreModule.dispatchers(),
                HandleUiError(coreModule, coreModule.provideGlobalErrorCommunication())
            ),
            coreModule.provideProgressCommunication(),
            CurrenciesCommunication.Base(),
            coreModule.dispatchers()
        )
    }
}