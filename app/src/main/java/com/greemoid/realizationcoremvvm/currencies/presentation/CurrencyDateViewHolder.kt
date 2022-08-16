package com.greemoid.realizationcoremvvm.currencies.presentation

import android.view.View
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.greemoid.realizationcoremvvm.R

class CurrencyDateViewHolder(view: View) : GenericViewHolder<ItemUi>(view) {
    override fun bind(item: ItemUi) {
        item.show(
            itemView.findViewById(R.id.dateTextView)
        )
    }
}