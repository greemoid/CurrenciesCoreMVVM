package com.greemoid.realizationcoremvvm.currencies.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.johnnysc.coremvvm.presentation.BackPress
import com.greemoid.realizationcoremvvm.R

class CurrenciesFragment : BackPress.Fragment<CurrenciesUi, CurrenciesViewModel>() {
    override val layoutResId: Int
        get() = R.layout.single_recycler_view_layout

    override fun viewModelClass(): Class<CurrenciesViewModel> {
        return CurrenciesViewModel::class.java
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val currenciesAdapter = CurrenciesAdapter.Currencies()
        recyclerView.adapter = currenciesAdapter

        viewModel.observe(this) { currenciesUi ->
            currenciesUi.map(currenciesAdapter)
        }
    }
}