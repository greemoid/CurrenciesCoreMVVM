package com.greemoid.realizationcoremvvm.favorites.presentation

import com.github.johnnysc.coremvvm.presentation.NavigationScreen
import com.github.johnnysc.coremvvm.presentation.ShowStrategy

class FavoritesNavigationScreen : NavigationScreen(
    id = "FavoritesNavigationScreen",
    clasz = FavoritesFragment::class.java,
    strategy = ShowStrategy.REPLACE
)