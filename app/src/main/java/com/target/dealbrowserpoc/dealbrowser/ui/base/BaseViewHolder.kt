package com.target.dealbrowserpoc.dealbrowser.ui.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

abstract class BaseViewHolder<out B : ViewDataBinding>(val binding: B) : RecyclerView.ViewHolder(
    binding.root) {
  protected fun context() = binding.root.context

}