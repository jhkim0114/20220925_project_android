package com.example.jhkim20220925

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val tab = tabLayout.newTab()
        tab.text = "탭4"

        tabLayout.addTab(tab)

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            tabLayout.selectTab(tab)
        }


    }
}