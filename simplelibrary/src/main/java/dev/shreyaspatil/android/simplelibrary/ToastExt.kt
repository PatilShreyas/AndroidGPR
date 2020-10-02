package dev.shreyaspatil.android.simplelibrary

import android.app.Activity
import android.widget.Toast

fun Activity.shortToast(message: String) = Toast.makeText(
    applicationContext,
    message,
    Toast.LENGTH_SHORT
).show()

fun Activity.longToast(message: String) = Toast.makeText(
    applicationContext,
    message,
    Toast.LENGTH_LONG
).show()