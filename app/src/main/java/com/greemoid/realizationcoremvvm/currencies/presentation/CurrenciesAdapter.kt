package com.greemoid.realizationcoremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.GenericAdapter
import com.github.johnnysc.coremvvm.presentation.adapter.ViewHolderFactoryChain

interface CurrenciesAdapter {

    class Currencies :
            GenericAdapter.Base(
                CurrencyViewHolderFactoryChain(
                    CurrencyDateViewHolderFactoryChain(
                        ViewHolderFactoryChain.Exception()
                    )
                )
            )

    class Favorites : GenericAdapter.Base(
        CurrencyViewHolderFactoryChain(
            ViewHolderFactoryChain.Exception()
        )
    )
}