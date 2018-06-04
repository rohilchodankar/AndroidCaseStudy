package com.target.dealbrowserpoc.dealbrowser.injection.component

import com.target.dealbrowserpoc.dealbrowser.BaseApplication
import com.target.dealbrowserpoc.dealbrowser.injection.module.ActivityBindingModule
import com.target.dealbrowserpoc.dealbrowser.injection.module.AppModule
import com.target.dealbrowserpoc.dealbrowser.injection.module.NetworkModule
import com.target.dealbrowserpoc.dealbrowser.injection.module.ViewModelFactoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ViewModelFactoryModule::class, AndroidSupportInjectionModule::class, ActivityBindingModule::class,
    NetworkModule::class))
interface AppComponent : AndroidInjector<BaseApplication> {

  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<BaseApplication>()

}
