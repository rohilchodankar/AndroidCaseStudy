package com.target.dealbrowserpoc.dealbrowser.ui.dealdetails

import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StrikethroughSpan
import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.Transition
import android.transition.Transition.TransitionListener
import android.transition.TransitionSet
import android.view.View
import com.target.dealbrowserpoc.dealbrowser.AppConstants
import com.target.dealbrowserpoc.dealbrowser.R
import com.target.dealbrowserpoc.dealbrowser.data.models.Deal
import com.target.dealbrowserpoc.dealbrowser.databinding.ActivityDealDetailsBinding
import com.target.dealbrowserpoc.dealbrowser.ui.base.BaseActivity
import com.target.dealbrowserpoc.dealbrowser.utils.kotlinExtensions.load
import com.target.dealbrowserpoc.dealbrowser.utils.kotlinExtensions.makeImageUrlDifferent
import java.util.Locale




class DealDetailsActivity : BaseActivity<ActivityDealDetailsBinding, DealDetailsActivityViewModel>() {

  override fun getViewModelClass(): Class<DealDetailsActivityViewModel> = DealDetailsActivityViewModel::class.java

  override fun layoutId(): Int = R.layout.activity_deal_details


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)


    intent?.getParcelableExtra<Deal>(AppConstants.INTENT_EXTRA_DEAL)?.let {
      val imageUrl = it.image.makeImageUrlDifferent(it.id)
      if(VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP){
        supportPostponeEnterTransition()
        binding.productImage.transitionName = imageUrl
        binding.productImage.load(it.image, true) {
          supportStartPostponedEnterTransition()
        }

        if(savedInstanceState != null){
          binding.productImage.load(imageUrl,true)
        }
        else{
          window.sharedElementEnterTransition = TransitionSet()
              .addTransition(ChangeImageTransform())
              .addTransition(ChangeBounds())
              .apply {
                this.addListener(object: TransitionListener{
                  override fun onTransitionResume(p0: Transition?) {

                  }
                  override fun onTransitionPause(p0: Transition?) {

                  }
                  override fun onTransitionCancel(p0: Transition?) {

                  }
                  override fun onTransitionStart(p0: Transition?) {

                  }
                  override fun onTransitionEnd(p0: Transition?) {
                    binding.productImage.load(imageUrl,true)
                  }
                })
              }
        }
      }
      else
      {
        binding.productImage.load(imageUrl,true)
      }

      binding.productTitle.text = it.title
      binding.productSalePrice.text = it.salePrice?: it.price
      if(it.salePrice == null) {
        binding.productPrice.visibility = View.GONE
      }else {
        val spannableString = SpannableString(String.format(Locale.US,getString(R
            .string.reg),it
            .price))
        spannableString.setSpan(StrikethroughSpan(),5,spannableString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.productPrice.text = spannableString

      }
      binding.productDescription.text = it.description
    }
  }

  override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
    super.onRestoreInstanceState(savedInstanceState)

  }
}
