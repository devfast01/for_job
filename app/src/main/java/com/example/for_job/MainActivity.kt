package com.example.for_job

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.for_job.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView

    private var homeFragment = HomeFragment()
    private var simpleFragment = simple_fragment()
    private var second = second()
    private var categoryFragment = CategoryFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        beginTransaction(simpleFragment)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    beginTransaction(simpleFragment)
                    Toast.makeText(applicationContext, "Home", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.action_category -> {
                  beginTransaction(second)
                    Toast.makeText(applicationContext, "category", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.action_favorites -> {
                    Toast.makeText(applicationContext, "Favorites", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.action_cart -> {
                    Toast.makeText(applicationContext, "Cart", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.action_profile -> {
                    true
                }
                else -> {
                    true
                }
            }
            return@setOnItemSelectedListener true
            }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_navigation_view, menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun beginTransaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }
}