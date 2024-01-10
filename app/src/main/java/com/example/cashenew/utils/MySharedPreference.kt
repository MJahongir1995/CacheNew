package com.example.cashenew.utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreference {
    private const val NAME = "cache_file_name"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var count: Int
        get() = sharedPreferences.getInt("count", 0)
        set(value) = sharedPreferences.edit {
            if (value != null) {
                it.putInt("count", value)
            }
        }
}