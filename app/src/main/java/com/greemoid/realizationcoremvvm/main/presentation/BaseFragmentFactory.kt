package com.greemoid.realizationcoremvvm.main.presentation

import androidx.fragment.app.FragmentManager
import com.github.johnnysc.coremvvm.presentation.FragmentFactory
import com.github.johnnysc.coremvvm.presentation.NavigationScreen
import com.greemoid.realizationcoremvvm.currencies.presentation.CurrenciesNavigationScreen
import com.greemoid.realizationcoremvvm.favorites.presentation.FavoritesNavigationScreen

class BaseFragmentFactory(
    containerId: Int,
    fragmentManager: FragmentManager,
) : FragmentFactory.Abstract(
    containerId,
    fragmentManager,
) {


    override val screens: List<NavigationScreen>
        get() = listOf(
            CurrenciesNavigationScreen(),
            FavoritesNavigationScreen()
        )
}