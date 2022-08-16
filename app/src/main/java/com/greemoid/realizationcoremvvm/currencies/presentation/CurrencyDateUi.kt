package com.greemoid.realizationcoremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.MyView

class CurrencyDateUi(
    private val text: String
) : ItemUi {
    override fun content(): String = text

    override fun id(): String = text

    override fun show(vararg views: MyView) {
        views[0].show(text)
    }

    override fun type(): Int {
        return 2
    }
}