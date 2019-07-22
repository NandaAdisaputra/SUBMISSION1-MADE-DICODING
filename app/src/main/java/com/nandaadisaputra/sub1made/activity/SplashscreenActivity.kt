package com.nandaadisaputra.sub1made.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.nandaadisaputra.sub1made.R
import org.jetbrains.anko.startActivity

@SuppressLint("Registered")
class SplashscreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
//TODO 8. Buat handler splashscreennya
        Handler().postDelayed({
            finish()
            //anko
            startActivity<MainActivity>()
        }, 3000)

    }
}

