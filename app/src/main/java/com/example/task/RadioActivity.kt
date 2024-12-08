package com.example.task

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RadioActivity : AppCompatActivity() {
    lateinit var download: RadioButton
    lateinit var abc: RadioButton
    lateinit var efg: RadioButton
    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio)

        abc = findViewById(R.id.radioAbc)
        download = findViewById(R.id.radioDownload)
        efg = findViewById(R.id.radioEfg)
        image = findViewById(R.id.imageRadio)

        abc.setOnClickListener{
            image.setImageResource(R.drawable.abc)
        }

        download.setOnClickListener{
            image.setImageResource(R.drawable.download)
        }

        efg.setOnClickListener{
            image.setImageResource(R.drawable.efg)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}