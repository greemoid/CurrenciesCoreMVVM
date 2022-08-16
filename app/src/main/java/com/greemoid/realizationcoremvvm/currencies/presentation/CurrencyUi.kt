package com.greemoid.realizationcoremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

class CurrencyUi(
    private val id: String,
    private val text: String,
    private val isFavorite: Boolean,
    private val changeFavorite: ChangeFavorite,
) : ItemUi {
    override fun content(): String = text + isFavorite

    override fun id(): String = id

    override fun show(vararg views: MyView) {
        views[0].show(text)
        views[1].check(isFavorite)
        views[1].handleClick {
            changeFavorite.changeFavorite(id)
        }
    }

    override fun type(): Int = 1
}