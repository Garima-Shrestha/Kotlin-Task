package com.example.task.UI.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.task.R
import com.example.task.adapter.TabAdapter
import com.example.task.databinding.ActivityOrder2Binding
import com.google.android.material.tabs.TabLayoutMediator

class OrderActivity : AppCompatActivity() {


    override fun onPause() {
        Log.d("Lifecycle","Onpause -> I am called")
        super.onPause()
    }

    override fun onResume() {
        Log.d("Lifecycle", "Onresume -> I am called")
        super.onResume()
    }

    override fun onStart() {
        Log.d("Lifecycle", "Onstart -> I am called")
        super.onStart()
    }

    override fun onDestroy() {
        Log.d("Lifecycle", "Ondestroy -> I am called")
        super.onDestroy()
    }

    lateinit var binding: ActivityOrder2Binding
    lateinit var adapter: TabAdapter

    // if tab layout ko header ma icon rakne bhaye
    val icons = arrayOf(
        R.drawable.baseline_home_24,
        R.drawable.baseline_notifications_24,
        R.drawable.baseline_person_24
    )

    // if tab layout ko header ma text rakne bhaye
    val data = arrayOf("Active Order", "Cancelled Order", "Delivered Order")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityOrder2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager: FragmentManager = supportFragmentManager
        adapter = TabAdapter(fragmentManager, lifecycle)

        binding.viewPager.adapter=adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){
            // if text rakne bhaye
//            tabs,position -> tabs.text = data[position]

            // if icons rakhne bhaye
            tabs,position -> tabs.icon = resources.getDrawable(icons[position], null)
        }.attach()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}