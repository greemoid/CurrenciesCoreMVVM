package com.greemoid.realizationcoremvvm.sl

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.github.johnnysc.coremvvm.sl.CoreModule
import com.github.johnnysc.coremvvm.sl.DependencyContainer
import com.github.johnnysc.coremvvm.sl.ProvideViewModel
import com.github.johnnysc.coremvvm.sl.ViewModelsFactory

class App : Application(), ProvideViewModel {

    private lateinit var viewModelsFactory: ViewModelsFactory

    override fun onCreate() {
        super.onCreate()
        val coreModule = CoreModule.Base(this)
        val main = MainDependencyContainer(DependencyContainer.Error(), coreModule)
        viewModelsFactory = ViewModelsFactory(FeatureDependencyContainer(coreModule, main))
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T =
        ViewModelProvider(owner, viewModelsFactory)[clazz]
}