package com.target.dealbrowserpoc.dealbrowser.utils.kotlinExtensions

/**
 * Created by rohilchodankar on 6/3/18.
 */
fun String.makeImageUrlDifferent(id : String) : String{
  return StringBuilder(this).append("?id=").append(id).toString()
}