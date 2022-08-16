package com.greemoid.realizationcoremvvm.currencies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.ViewHolderFactoryChain
import com.greemoid.realizationcoremvvm.R

class CurrencyDateViewHolderFactoryChain(
    private val viewHolderFactoryChain: ViewHolderFactoryChain<ItemUi>,
) : ViewHolderFactoryChain<ItemUi> {
    override fun viewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<ItemUi> =
        if (viewType == 2)
            CurrencyDateViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.currency_date_layout, parent, false)
            )
        else viewHolderFactoryChain.viewHolder(parent, viewType)
}