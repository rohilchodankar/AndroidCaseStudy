package com.target.dealbrowserpoc.dealbrowser.injection.module

import android.content.Context
import com.target.dealbrowserpoc.dealbrowser.BaseApplication
import com.target.dealbrowserpoc.dealbrowser.injection.qualifiers.ApplicationContext
import com.target.dealbrowserpoc.dealbrowser.utils.IRxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class AppModule {

  @Provides
  @Singleton internal fun provideRxSchedulers(): IRxSchedulers {
    return object : IRxSchedulers {
      override fun main() = AndroidSchedulers.mainThread()
      override fun io() = Schedulers.io()
    }
  }

  @Provides
  @ApplicationContext
  fun provideAppContext(app: BaseApplication): Context = app.applicationContext
}
