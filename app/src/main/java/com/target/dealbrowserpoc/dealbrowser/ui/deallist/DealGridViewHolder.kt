package com.target.dealbrowserpoc.dealbrowser.ui.deallist

import android.graphics.Color
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.target.dealbrowserpoc.dealbrowser.R.string
import com.target.dealbrowserpoc.dealbrowser.data.models.Deal
import com.target.dealbrowserpoc.dealbrowser.databinding.DealGridItemBinding
import com.target.dealbrowserpoc.dealbrowser.ui.base.BaseViewHolder
import com.target.dealbrowserpoc.dealbrowser.utils.kotlinExtensions.load
import com.target.dealbrowserpoc.dealbrowser.utils.kotlinExtensions.makeImageUrlDifferent

/**
 * Created by rohilchodankar on 6/4/18.
 */
class DealGridViewHolder(binding: DealGridItemBinding) : BaseViewHolder<DealGridItemBinding>(binding)
{
  var ship : SpannableString
  var or : SpannableString

  init {
    ship = SpannableString(binding.root.context.getString(string.ship))
    or = SpannableString(binding.root.context.getString(string.or))
  }

  fun bindGridData(deal: Deal,dealAdapterCallback : DealListAdapter.DealAdapterCallback?){
    binding.dealListItemTitle.text = deal.title
    binding.dealListItemPrice.text = deal.salePrice?: deal.price

    binding.root.setOnClickListener {
      dealAdapterCallback?.navigateToDealDetails(deal,binding.dealListItemImageView)
    }

    ship.setSpan(ForegroundColorSpan(Color.BLACK), 0, ship.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    binding.shipIndicator.setText(ship)

    or.setSpan(ForegroundColorSpan(Color.LTGRAY), 0, or.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    binding.shipIndicator.append(" " +  or)

    binding.aisleIndicator.text = deal.aisle

    binding.dealListItemImageView.apply {
      val imageUrl = deal.image.makeImageUrlDifferent(deal.id)
      load(imageUrl)
      if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
        transitionName = imageUrl
      }
    }
  }

}