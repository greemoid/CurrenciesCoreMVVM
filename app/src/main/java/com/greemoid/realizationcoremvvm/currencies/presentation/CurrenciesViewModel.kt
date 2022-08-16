package com.greemoid.realizationcoremvvm.currencies.presentation

import android.util.Log
import com.github.johnnysc.coremvvm.core.Dispatchers
import com.github.johnnysc.coremvvm.presentation.BackPress
import com.github.johnnysc.coremvvm.presentation.CanGoBack
import com.github.johnnysc.coremvvm.presentation.ProgressCommunication
import com.github.johnnysc.coremvvm.presentation.Visibility
import com.greemoid.realizationcoremvvm.currencies.domain.CurrenciesInteractor

class CurrenciesViewModel(
    canGoBackCallback: CanGoBack.Callback,
    private val interactor: CurrenciesInteractor,
    progressCommunication: ProgressCommunication.Update,
    communication: CurrenciesCommunication,
    dispatchers: Dispatchers
) : BackPress.ViewModel<CurrenciesUi>(canGoBackCallback, communication, dispatchers) {

    private val atFinish = {
        progressCommunication.map(Visibility.Gone())
        canGoBack = true
    }

    private var canGoBack = true

    private val canGoBackCallbackListener = object : CanGoBack {
        override fun canGoBack(): Boolean = canGoBack
    }

    init {
        canGoBack = false
        progressCommunication.map(Visibility.Visible())
        handle {
            interactor.currencies(atFinish) {communication.map(it)}
        }
    }

    override fun updateCallbacks() {
        canGoBackCallback.updateCallback(canGoBackCallbackListener)
    }
}