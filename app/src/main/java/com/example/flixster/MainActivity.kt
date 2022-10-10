package com.example.flixster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flixster.R.id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_layout)
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.content, LatestMovieFragment(), null).commit()

    }
}