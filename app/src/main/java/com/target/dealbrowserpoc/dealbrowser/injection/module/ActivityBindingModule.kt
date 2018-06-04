package com.target.dealbrowserpoc.dealbrowser.injection.module

import com.target.dealbrowserpoc.dealbrowser.injection.scope.ActivityScope
import com.target.dealbrowserpoc.dealbrowser.ui.dealdetails.DealDetailsActivity
import com.target.dealbrowserpoc.dealbrowser.ui.deallist.DealListActivity
import com.target.dealbrowserpoc.dealbrowser.ui.deallist.DealListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector(
      modules = [DealListActivityModule::class])
  internal abstract fun bindDealListActivity(): DealListActivity

  @ActivityScope
  @ContributesAndroidInjector()
  internal abstract fun bindDealDetailsActivity(): DealDetailsActivity
}


/**
 * Activity specific common dependencies should be placed here
 */
@Module
open class BaseActivityModule {

}