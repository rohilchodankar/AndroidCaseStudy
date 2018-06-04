package com.target.dealbrowserpoc.dealbrowser.utils

import android.content.Context
import android.content.SharedPreferences
import com.target.dealbrowserpoc.dealbrowser.AppConstants.LIST
import com.target.dealbrowserpoc.dealbrowser.AppConstants.PREFS_FILE_NAME
import com.target.dealbrowserpoc.dealbrowser.injection.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrefsUtils @Inject constructor(@ApplicationContext private var context: Context) {

  val prefs: SharedPreferences by lazy {
    context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)
  }

  //Clear Saved Preferences
  fun clearPrefs() = prefs.edit().clear().apply()

  var userContentStylePreferences: Int
    set(value) = prefs.edit().putInt(USER_CONTENT_STYLE_PREF, value).apply()
    get() = prefs.getInt(USER_CONTENT_STYLE_PREF, LIST)


  private val USER_CONTENT_STYLE_PREF = "user_content_style_pref"

}