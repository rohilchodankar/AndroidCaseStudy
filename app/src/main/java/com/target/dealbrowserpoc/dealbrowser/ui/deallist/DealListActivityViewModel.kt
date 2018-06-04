package com.target.dealbrowserpoc.dealbrowser.ui.deallist

import android.arch.lifecycle.MutableLiveData
import com.target.dealbrowserpoc.dealbrowser.data.models.DealMetaData
import com.target.dealbrowserpoc.dealbrowser.data.services.DealService
import com.target.dealbrowserpoc.dealbrowser.injection.scope.ActivityScope
import com.target.dealbrowserpoc.dealbrowser.ui.base.BaseViewModel
import com.target.dealbrowserpoc.dealbrowser.utils.IRxSchedulers
import com.target.dealbrowserpoc.dealbrowser.utils.PrefsUtils
import javax.inject.Inject

/**
 * Created by rohilchodankar on 6/3/18.
 */
@ActivityScope
class DealListActivityViewModel @Inject constructor() : BaseViewModel() {

  @Inject lateinit var service: DealService
  @Inject lateinit var schedulers: IRxSchedulers
  @Inject lateinit var prefsUtils: PrefsUtils

  var dealMetaData : MutableLiveData<DealMetaData> = MutableLiveData()
  var progressIndicatorState : MutableLiveData<Boolean> = MutableLiveData()

  fun loadDeals(){
    showProgressIndicator()
    addDisposable(service.getDealsList()
        .subscribeOn(schedulers.io())
        .observeOn(schedulers.main())
        .doFinally {  hideProgressIndicator() }
        .subscribe({
          dealMetaData.postValue(it)
        }, {

    }))
  }

  private fun hideProgressIndicator(){
    progressIndicatorState.postValue(false)
  }

  private fun showProgressIndicator(){
    progressIndicatorState.postValue(true)
  }


}