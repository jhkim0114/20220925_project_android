package com.example.jhkim20220925

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.jhkim20220925.databinding.ActivityMain1Binding
import com.example.jhkim20220925.databinding.ItemTestBinding

class MainActivity1 : AppCompatActivity() {


    private lateinit var binding: ActivityMain1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main1)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val item: MutableList<Test> = mutableListOf()

        for (i: Int in 1..10) {
            item.add(
                Test(
                    "test_$i",
                    false
                )
            )
        }

        binding.recyclerView.adapter = CustomAdapter(item)





    }
}



class CustomAdapter(val itemList: List<Test>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(val binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: ItemTestBinding = ItemTestBinding.inflate(LayoutInflater.from(parent.context))

        binding.checkBoxTest.setOnClickListener {
            Log.d("hoho","checkBox: ${binding.checkBoxTest.isChecked}")

            itemList.forEach {
                it.isChecked = binding.checkBoxTest.isChecked
            }

            itemList.forEach {
                Log.d("hoho", "itemList isChecked: ${it.isChecked}")
//                Log.d("hoho", "itemList size: ${itemList.size}")


            }



        }


        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (holder.binding) {
            is ItemTestBinding -> {
                holder.binding.textViewTest.text = itemList[position].text
                holder.binding.checkBoxTest.isChecked = itemList[position].isChecked
            }
        }

    }

    override fun getItemCount(): Int = itemList.size


}

data class Test(
    val text: String,
    var isChecked: Boolean
)