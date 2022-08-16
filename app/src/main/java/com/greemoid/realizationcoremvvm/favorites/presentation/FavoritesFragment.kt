package com.greemoid.realizationcoremvvm.favorites.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.johnnysc.coremvvm.presentation.BackPress
import com.github.johnnysc.coremvvm.presentation.BaseFragment
import com.greemoid.realizationcoremvvm.R
import com.greemoid.realizationcoremvvm.currencies.presentation.CurrenciesAdapter

class FavoritesFragment : BaseFragment<FavoritesViewModel>() {
    override val layoutResId: Int
        get() = R.layout.single_recycler_view_layout

    override fun viewModelClass(): Class<FavoritesViewModel> {
        return FavoritesViewModel::class.java
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val currenciesAdapter = CurrenciesAdapter.Favorites()
        recyclerView.adapter = currenciesAdapter

        viewModel.observe(this) { favoritesUi ->
            favoritesUi.map(currenciesAdapter)
        }

        viewModel.observeUpdate(this) {
            viewModel.update()
        }
    }
}