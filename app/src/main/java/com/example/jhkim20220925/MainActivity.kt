package com.example.jhkim20220925

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener
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

        val editText = findViewById<EditText>(R.id.editText)
        val constraintLayoutSearch = findViewById<ConstraintLayout>(R.id.constraintLayout_search)
        editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("hoho", "hoho beforeTextChanged: $p0")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("hoho", "hoho onTextChanged: $p0")
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.d("hoho", "hoho afterTextChanged: $p0")


                if (editText.text.isEmpty()) {
                    constraintLayoutSearch.visibility = View.GONE
                } else {
                    constraintLayoutSearch.visibility = View.VISIBLE
                }

            }
        })



    }
}