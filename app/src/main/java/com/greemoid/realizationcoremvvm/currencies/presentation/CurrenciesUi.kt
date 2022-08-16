package com.greemoid.realizationcoremvvm.currencies.presentation

import com.github.johnnysc.coremvvm.core.Mapper
import com.github.johnnysc.coremvvm.presentation.adapter.ItemUi

interface CurrenciesUi : Mapper.Unit<Mapper.Unit<List<ItemUi>>> {

    class Base(private val list: List<ItemUi>) : CurrenciesUi {
        override fun map(data: Mapper.Unit<List<ItemUi>>) {
            return data.map(list)
        }
    }
}