package com.target.dealbrowserpoc.dealbrowser.ui.deallist

import android.databinding.ViewDataBinding
import android.text.SpannableString
import com.target.dealbrowserpoc.dealbrowser.R.string
import com.target.dealbrowserpoc.dealbrowser.data.models.Deal
import com.target.dealbrowserpoc.dealbrowser.ui.base.BaseViewHolder

/**
 * Created by rohilchodankar on 6/4/18.
 */
abstract class BaseDealViewHolder<out B: ViewDataBinding>(binding: B) : BaseViewHolder<B>(binding)  {

  var ship : SpannableString
  var or : SpannableString

  init {
    ship = SpannableString(binding.root.context.getString(string.ship))
    or = SpannableString(binding.root.context.getString(string.or))
  }


  abstract fun bindData(deal: Deal,dealAdapterCallback : DealListAdapter.DealAdapterCallback?)

}
