package com.greemoid.realizationcoremvvm.currencies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.johnnysc.coremvvm.presentation.adapter.GenericViewHolder
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi
import com.github.johnnysc.coremvvm.presentation.adapter.ViewHolderFactoryChain
import com.greemoid.realizationcoremvvm.R

class CurrencyViewHolderFactoryChain(
    private val viewHolderFactoryChain: ViewHolderFactoryChain<ItemUi>,
) : ViewHolderFactoryChain<ItemUi> {
    override fun viewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<ItemUi> {
        return if (viewType == 1)
            CurrencyViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.currency_layout, parent, false)
            )
        else viewHolderFactoryChain.viewHolder(parent, viewType)
    }
}