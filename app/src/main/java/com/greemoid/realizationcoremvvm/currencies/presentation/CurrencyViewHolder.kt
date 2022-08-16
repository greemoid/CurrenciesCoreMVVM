package com.greemoid.realizationcoremvvm.currencies.presentation

import android.view.View
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.greemoid.realizationcoremvvm.R

class CurrencyViewHolder(
    view: View
) : GenericViewHolder<ItemUi>(view) {
    override fun bind(item: ItemUi) = with(itemView) {
        item.show(
            findViewById(R.id.currencyTextView),
            findViewById(R.id.compoundButton)
        )
    }
}