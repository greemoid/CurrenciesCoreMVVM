package com.greemoid.realizationcoremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.Communication

interface CurrenciesCommunication : Communication.Mutable<CurrenciesUi>{
    class Base : Communication.UiUpdate<CurrenciesUi>(), CurrenciesCommunication
}