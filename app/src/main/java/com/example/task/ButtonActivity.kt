package com.example.task

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {

    lateinit var binding: ActivityButtonBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences=getSharedPreferences("userData", Context.MODE_PRIVATE)

        binding.btnNavigate.setOnClickListener {

            val user: String = binding.username.text.toString()
            val pass: String = binding.password.text.toString()

            if (user.isEmpty()) {
                binding.password.error = "User can't be empty"
            } else if (pass.isEmpty()) {
                binding.password.error = "Password can't be empty"
            } else {
                if(binding.checkBox.isChecked){
                    val editor = sharedPreferences.edit()
                    editor.putString("username", user)
                    editor.putString("password", pass)
                    editor.apply()
                }
                val intent = Intent(this@ButtonActivity, DestinationActivity::class.java)
                intent.putExtra("username", user)
                intent.putExtra("password", pass)
                startActivity(intent)
                finish()    //if yo garyo bhnaye tyo activity back jadaina
            }


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}