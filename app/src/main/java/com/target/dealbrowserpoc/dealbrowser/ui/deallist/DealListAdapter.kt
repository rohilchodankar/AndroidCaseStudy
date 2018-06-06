package com.target.dealbrowserpoc.dealbrowser.ui.deallist

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.target.dealbrowserpoc.dealbrowser.AppConstants.GRID
import com.target.dealbrowserpoc.dealbrowser.AppConstants.LIST
import com.target.dealbrowserpoc.dealbrowser.data.models.Deal
import com.target.dealbrowserpoc.dealbrowser.databinding.DealGridItemBinding
import com.target.dealbrowserpoc.dealbrowser.databinding.DealListItemBinding
import com.target.dealbrowserpoc.dealbrowser.injection.scope.ActivityScope
import com.target.dealbrowserpoc.dealbrowser.utils.PrefsUtils
import javax.inject.Inject

/**
 * Created by rohilchodankar on 6/3/18.
 */
@ActivityScope
class DealListAdapter @Inject constructor(val prefsUtils: PrefsUtils) : RecyclerView.Adapter<BaseDealViewHolder<ViewDataBinding>>() {

  var dealList : MutableList<Deal> = ArrayList()
  var dealAdapterCallback : DealAdapterCallback? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseDealViewHolder<ViewDataBinding> {
    return when(prefsUtils.userContentStylePreferences){
      LIST -> DealListViewHolder(
          DealListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
      GRID -> DealGridViewHolder(
          DealGridItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
      else -> DealListViewHolder(
          DealListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
  }

  override fun getItemCount(): Int = dealList.size

  override fun onBindViewHolder(holder: BaseDealViewHolder<ViewDataBinding>, position: Int) {
    holder.bindData(dealList.get(position), dealAdapterCallback)
  }

  interface DealAdapterCallback {
    fun navigateToDealDetails(deal: Deal,imageView: ImageView)
  }
}