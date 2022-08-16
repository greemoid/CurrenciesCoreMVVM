package com.greemoid.realizationcoremvvm.favorites.presentation


import com.github.johnnysc.coremvvm.presentation.Communication
import com.greemoid.realizationcoremvvm.currencies.presentation.CurrenciesUi

interface FavoritesCommunication : Communication.Mutable<CurrenciesUi> {
    class Base : Communication.UiUpdate<CurrenciesUi>(), FavoritesCommunication
}