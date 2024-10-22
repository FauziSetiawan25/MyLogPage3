package com.example.mylogpage3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    companion object{
        @StringRes
        private val  TAB_TITLES = intArrayOf(R.string.login, R.string.register)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager : ViewPager2 = findViewById(R.id.viewPager)
        viewPager.adapter = sectionPagerAdapter

        val tabs : TabLayout = findViewById(R.id.tabLayout)
        TabLayoutMediator(tabs, viewPager){
                tab, position -> tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }
}
