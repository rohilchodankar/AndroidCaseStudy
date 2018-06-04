package com.target.dealbrowserpoc.dealbrowser.ui.decorators

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import com.target.dealbrowserpoc.dealbrowser.R


/**
 * Created by rohilchodankar on 6/3/18.
 */
class SimpleDividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
  private var mDivider: Drawable?= null

  init {
    mDivider = ContextCompat.getDrawable(context,R.drawable.line_divider)
  }

  override  fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
    val left = parent.paddingLeft
    val right = parent.width - parent.paddingRight

    val childCount = parent.childCount
    for (i in 0 until childCount) {
      val child = parent.getChildAt(i)

      val params = child.layoutParams as RecyclerView.LayoutParams

      mDivider?.let {
        val top = child.bottom + params.bottomMargin
        val bottom = top + it.intrinsicHeight

        it.setBounds(left, top, right, bottom)
        it.draw(c)
      }
    }
  }
}