package dev.shreyaspatil.android.gprdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.shreyaspatil.android.simplelibrary.longToast
import dev.shreyaspatil.android.simplelibrary.shortToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shortToast("Here's short toast")
        longToast("Here's long toast")
    }
}