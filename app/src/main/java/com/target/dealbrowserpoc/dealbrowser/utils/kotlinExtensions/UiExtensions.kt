package com.target.dealbrowserpoc.dealbrowser.utils.kotlinExtensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.target.dealbrowserpoc.dealbrowser.R

/**
 * Created by rohilchodankar on 6/3/18.
 */
fun ImageView.load(url: String, loadOnlyFromCache: Boolean = false, onLoadingFinished: () -> Unit = {}) {
  val listener = object : RequestListener<Drawable> {
    override fun onLoadFailed(e: GlideException?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?,
        isFirstResource: Boolean): Boolean {
      onLoadingFinished()
      return false
    }

    override fun onResourceReady(resource: Drawable?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?,
        dataSource: DataSource?, isFirstResource: Boolean): Boolean {
      onLoadingFinished()
      return false
    }
  }
  val requestOptions = RequestOptions.placeholderOf(R.drawable.image_16710656)
      .dontTransform()
      .onlyRetrieveFromCache(loadOnlyFromCache)
      .timeout(30000)

  Glide.with(this)
      .load(url)
      .apply(requestOptions)
      .listener(listener)
      .into(this)
}