package com.greemoid.realizationcoremvvm.sl

import com.github.johnnysc.coremvvm.presentation.NavigationCommunication
import com.github.johnnysc.coremvvm.sl.CoreModule
import com.github.johnnysc.coremvvm.sl.Module
import com.greemoid.realizationcoremvvm.main.presentation.MainViewModel

class MainModule(
    private val coreModule: CoreModule,
) : Module<MainViewModel> {
    override fun viewModel(): MainViewModel {
        return MainViewModel(
            coreModule.provideCanGoBack(),
            NavigationCommunication.Base(),
            coreModule.provideProgressCommunication(),
            coreModule.dispatchers(),
            coreModule.provideGlobalErrorCommunication()
        )
    }

}