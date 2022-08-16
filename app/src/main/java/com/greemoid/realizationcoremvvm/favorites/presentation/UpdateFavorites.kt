package com.greemoid.realizationcoremvvm.favorites.presentation

import com.github.johnnysc.coremvvm.presentation.Communication

interface UpdateFavorites {

    interface Observe : Communication.Observe<Boolean>
    interface Update : Communication.Update<Boolean>

    class Base : Communication.SingleUiUpdate<Boolean>(), Observe, Update
}