package com.example.backstackswithextension

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            setUpBottomNav()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setUpBottomNav() {
        val controller = bottomNav.setupWithNavController1(
            listOf(R.navigation.main_feed, R.navigation.post),
            supportFragmentManager,
            R.id.fragNavHost,
            intent
        )
        controller.observe(this) {
            setupActionBarWithNavController(it)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setUpBottomNav()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}