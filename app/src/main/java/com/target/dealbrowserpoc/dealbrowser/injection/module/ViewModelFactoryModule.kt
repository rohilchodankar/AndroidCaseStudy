package com.target.dealbrowserpoc.dealbrowser.injection.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.target.dealbrowserpoc.dealbrowser.injection.scope.ViewModelScope
import com.target.dealbrowserpoc.dealbrowser.ui.dealdetails.DealDetailsActivityViewModel
import com.target.dealbrowserpoc.dealbrowser.ui.deallist.DealListActivityViewModel
import com.target.dealbrowserpoc.dealbrowser.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

  @Binds
  @IntoMap
  @ViewModelScope(DealListActivityViewModel::class)
  abstract fun bindDealListActivityViewModel(dealListActivityViewModel: DealListActivityViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelScope(DealDetailsActivityViewModel::class)
  abstract fun bindDealDetailsActivityViewModel(dealDetailsActivityViewModel: DealDetailsActivityViewModel): ViewModel


  @Binds
  internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
