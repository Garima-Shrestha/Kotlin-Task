package com.example.task

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task.databinding.ActivityDestinationBinding

class DestinationActivity : AppCompatActivity() {

    lateinit var binding: ActivityDestinationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_destination)

        binding = ActivityDestinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user: String = intent.getStringExtra("username").toString()
        val pass : String = intent.getStringExtra("password").toString()

        binding.outputUsername.text = user
        binding.outputPassword.text = pass


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}