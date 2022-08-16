package com.greemoid.realizationcoremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.NavigationScreen
import com.github.johnnysc.coremvvm.presentation.ShowStrategy

class CurrenciesNavigationScreen(
    showStrategy: ShowStrategy = ShowStrategy.REPLACE
) : NavigationScreen(
    id = "CurrenciesNavigationScreen",
    clasz = CurrenciesFragment::class.java,
    strategy = showStrategy
)